package com.kiselyov.components.rest;

import com.kiselyov.components.entity.Responsible;
import com.kiselyov.components.errorHandlers.ResponsibleNotFoundException;
import com.kiselyov.components.service.ResponsibleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="responsibles", description="Operations on responsibles")
public class ResponsiblesRestController {

    private ResponsibleService responsibleService;

    @Autowired
    public ResponsiblesRestController(ResponsibleService theResponsibleService){
        this.responsibleService = theResponsibleService;
    }

    @ApiOperation(value = "View a list of available responsibles", response = Iterable.class)
    @GetMapping("/responsibles")
    public List<Responsible> findAll() {
        return responsibleService.findAll();
    }

    @ApiOperation(value = "View responsible by id")
    @GetMapping("responsibles/{responsibleId}")
    public Responsible getResponsible(@PathVariable int responsibleId) {
        return responsibleService.findById(responsibleId);
    }

    @ApiOperation(value = "Add new responsible")
    @PostMapping("/responsibles")
    public Responsible addResponsible(@RequestBody Responsible theResponsible){
        // this is to force a save of new item ... instead of update
        theResponsible.setResponsibleId(0);
        responsibleService.save(theResponsible);

        return theResponsible;
    }

    @ApiOperation(value = "Update responsible")
    @PutMapping("/responsibles")
    public Responsible updateResponsible(@RequestBody Responsible theResponsible) {
        responsibleService.save(theResponsible);
        return theResponsible;
    }

    @ApiOperation(value = "Delete responsible")
    @DeleteMapping("/responsibles/{responsibleId}")
    public String deleteResponsible(@PathVariable int responsibleId) {
        Responsible tempResponsible = responsibleService.findById(responsibleId);

        if(tempResponsible == null) {
            throw new ResponsibleNotFoundException();
        }

        responsibleService.deleteById(responsibleId);
        return "Deleted responsible id - " + responsibleId;
    }
}
