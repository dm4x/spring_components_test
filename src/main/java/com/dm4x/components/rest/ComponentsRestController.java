package com.dm4x.components.rest;

import com.dm4x.components.entity.Component;
import com.dm4x.components.errorHandlers.ComponentNotFoundException;
import com.dm4x.components.service.ComponentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="components", description="operations on components")
public class ComponentsRestController {

    private ComponentService componentService;

    @Autowired
    public ComponentsRestController(ComponentService theComponentService){
        this.componentService = theComponentService;
    }

    @GetMapping("/components")
    public List<Component> findAll() {
        return componentService.findAll();
    }

    // add mapping for GET components/{componentId}
    @GetMapping("components/{componentId}")
    public Component getComponent(@PathVariable int componentId) {
        return componentService.findById(componentId);
    }

    // add mapping for POST /components - add new component
    @PostMapping("/components")
    public Component addComponent(@RequestBody Component theComponent){
        // this is to force a save of new item ... instead of update
        theComponent.setComponentId(0);
        componentService.save(theComponent);

        return theComponent;
    }

    // add mapping for PUT /components - update existing components
    @PutMapping("/components")
    public Component updateComponent(@RequestBody Component theComponent) {
        componentService.save(theComponent);
        return theComponent;
    }

    // add mapping for DELETE /components/{componentId} - delete component
    @DeleteMapping("/components/{componentId}")
    public String deleteComponent(@PathVariable int componentId) {
        Component tempComponent = componentService.findById(componentId);

        if(tempComponent == null) {
            throw new ComponentNotFoundException();
        }

        componentService.deleteById(componentId);
        return "Deleted component id - " + componentId;
    }

}
