package com.dm4x.components.rest;

import com.dm4x.components.entity.Responsible;
import com.dm4x.components.entity.Version;
import com.dm4x.components.errorHandlers.VersionNotFoundException;
import com.dm4x.components.service.VersionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api
public class VersionsRestController {
    private VersionService versionService;

    @Autowired
    public VersionsRestController(VersionService theVersionService){
        this.versionService = theVersionService;
    }

    @GetMapping("/versions")
    public List<Version> findAll() {
        return versionService.findAll();
    }

    @GetMapping("versions/{versionId}")
    public Version getVersion(@PathVariable int versionId) {
        return versionService.findById(versionId);
    }

    // add mapping for POST /versions - add new version
    @PostMapping("/versions")
    public Version addVersion(@RequestBody Version theVersion){
        // this is to force a save of new item ... instead of update
        theVersion.setVersionId(0);
        versionService.save(theVersion);

        return theVersion;
    }

    // add mapping for PUT /versinos - update existing version
    @PutMapping("/versions")
    public Version updateVersion(@RequestBody Version theVersion) {
        versionService.save(theVersion);
        return theVersion;
    }

    // add mapping for DELETE /versions/{versionId} - delete version
    @DeleteMapping("/versions/{versionId}")
    public String deleteVersion(@PathVariable int versionId) {
        Version tempVersion = versionService.findById(versionId);

        if(tempVersion == null) {
            throw new VersionNotFoundException();
        }

        versionService.deleteById(versionId);
        return "Deleted version id - " + versionId;
    }

}
