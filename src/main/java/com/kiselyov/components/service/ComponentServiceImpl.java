package com.kiselyov.components.service;

import com.kiselyov.components.DAO.ComponentRepository;
import com.kiselyov.components.entity.Component;
import com.kiselyov.components.errorHandlers.ComponentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentServiceImpl implements ComponentService{

    private ComponentRepository componentRepository;

    @Autowired
    public ComponentServiceImpl(ComponentRepository theComponentRepository){
        this.componentRepository = theComponentRepository;
    }

    @Override
    public List<Component> findAll() {
        return componentRepository.findAll();
    }


    @Override
    public Component findById(int theId) {
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
    public void save(Component theComponent) {
        componentRepository.save(theComponent);
    }

    @Override
    public void deleteById(int theId) {
        componentRepository.deleteById(theId);
    }
}
