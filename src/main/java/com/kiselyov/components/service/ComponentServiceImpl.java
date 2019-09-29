package com.kiselyov.components.service;

import com.kiselyov.components.DAO.ComponentRepository;
import com.kiselyov.components.entity.Component;
import com.kiselyov.components.errorHandlers.ComponentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentServiceImpl implements ComponentService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ComponentRepository componentRepository;

    @Autowired
    public ComponentServiceImpl(ComponentRepository theComponentRepository){
        this.componentRepository = theComponentRepository;
    }

    @Override
    public List<Component> findAllComponents() {
        logger.debug("findAllComponents called");
        return componentRepository.findAll();
    }


    @Override
    public Component findComponentById(int theId) {
        logger.debug("findComponentById called");
        Optional<Component> result = componentRepository.findById(theId);

        Component theComponent = null;
        if(result.isPresent()) {
            theComponent = result.get();
        }
        else {
            throw new ComponentNotFoundException();
        }

        return theComponent;

    }

    @Override
    public void saveComponent(Component theComponent) {
        logger.debug("saveComponent called");
        componentRepository.save(theComponent);
    }

    @Override
    public void deleteComponentById(int theId) {
        logger.debug("deleteComponentById called");
        componentRepository.deleteById(theId);
    }
}
