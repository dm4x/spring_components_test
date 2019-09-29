package com.kiselyov.components.rest;

import com.kiselyov.components.entity.Component;
import com.kiselyov.components.errorHandlers.ComponentNotFoundException;
import com.kiselyov.components.service.ComponentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="ComponentsController", description="Operations on components")
public class ComponentsRestController {

    private ComponentService componentService;

    @Autowired
    public ComponentsRestController(ComponentService theComponentService){
        this.componentService = theComponentService;
    }

    @ApiOperation(value = "View a list of available components", response = Component.class)
    @GetMapping("/components")
    public List<Component> findAll() {
        return componentService.findAllComponents();
    }

    @ApiOperation(value = "View component by id")
    @GetMapping("components/{componentId}")
    public Component getComponent(@PathVariable int componentId) {
        return componentService.findComponentById(componentId);
    }

    @ApiOperation(value = "Add new component")
    @PostMapping("/components")
    public Component addComponent(@RequestBody Component theComponent){
        theComponent.setComponentId(0);
        componentService.saveComponent(theComponent);

        return theComponent;
    }

    @ApiOperation(value = "Update component")
    @PutMapping("/components")
    public Component updateComponent(@RequestBody Component theComponent) {
        componentService.saveComponent(theComponent);
        return theComponent;
    }

    @ApiOperation(value = "Delete component")
    @DeleteMapping("/components/{componentId}")
    public String deleteComponent(@PathVariable int componentId) {
        Component tempComponent = componentService.findComponentById(componentId);

        if(tempComponent == null) {
            throw new ComponentNotFoundException();
        }

        componentService.deleteComponentById(componentId);
        return "Deleted component id - " + componentId;
    }

}
