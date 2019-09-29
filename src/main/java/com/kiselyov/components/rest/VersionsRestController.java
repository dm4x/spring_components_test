package com.kiselyov.components.rest;

import com.kiselyov.components.entity.Version;
import com.kiselyov.components.errorHandlers.VersionNotFoundException;
import com.kiselyov.components.service.VersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="VersionsController", description="Operations on versions")
public class VersionsRestController {
    private VersionService versionService;

    @Autowired
    public VersionsRestController(VersionService theVersionService){
        this.versionService = theVersionService;
    }

    @ApiOperation(value = "View a list of available versions", response = Iterable.class)
    @GetMapping("/versions")
    public List<Version> findAll() {
        return versionService.findAllVersions();
    }

    @ApiOperation(value = "View version by id")
    @GetMapping("versions/{versionId}")
    public Version getVersion(@PathVariable int versionId) {
        return versionService.findVersionById(versionId);
    }

    @ApiOperation(value = "Add new version")
    @PostMapping("/versions")
    public Version addVersion(@RequestBody Version theVersion){
        theVersion.setVersionId(0);
        versionService.saveVersion(theVersion);
        return theVersion;
    }

    @ApiOperation(value = "Update version")
    @PutMapping("/versions")
    public Version updateVersion(@RequestBody Version theVersion) {
        versionService.saveVersion(theVersion);
        return theVersion;
    }

    @ApiOperation(value = "Delete version")
    @DeleteMapping("/versions/{versionId}")
    public String deleteVersion(@PathVariable int versionId) {
        Version tempVersion = versionService.findVersionById(versionId);

        if(tempVersion == null) {
            throw new VersionNotFoundException();
        }

        versionService.deleteVersionById(versionId);
        return "Deleted version id - " + versionId;
    }

}
