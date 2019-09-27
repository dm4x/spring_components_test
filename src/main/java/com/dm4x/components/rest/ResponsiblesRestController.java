package com.dm4x.components.rest;

import com.dm4x.components.entity.Responsible;
import com.dm4x.components.errorHandlers.ResponsibleNotFoundException;
import com.dm4x.components.service.ResponsibleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="responsibles", description="operations on responsibles")
public class ResponsiblesRestController {

    private ResponsibleService responsibleService;

    @Autowired
    public ResponsiblesRestController(ResponsibleService theResponsibleService){
        this.responsibleService = theResponsibleService;
    }

    @GetMapping("/responsibles")
    public List<Responsible> findAll() {
        return responsibleService.findAll();
    }

    // add mapping for GET esponsibles/{responsibleId}
    @GetMapping("responsibles/{responsibleId}")
    public Responsible getResponsible(@PathVariable int responsibleId) {
        return responsibleService.findById(responsibleId);
    }

    // add mapping for POST /responsibles - add new responsible
    @PostMapping("/responsibles")
    public Responsible addResponsible(@RequestBody Responsible theResponsible){
        // this is to force a save of new item ... instead of update
        theResponsible.setResponsibleId(0);
        responsibleService.save(theResponsible);

        return theResponsible;
    }

    // add mapping for PUT /responsibles - update existing responsible
    @PutMapping("/responsibles")
    public Responsible updateResponsible(@RequestBody Responsible theResponsible) {
        responsibleService.save(theResponsible);
        return theResponsible;
    }

    // add mapping for DELETE /responsibles/{seronsibleId} - delete responsible
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
