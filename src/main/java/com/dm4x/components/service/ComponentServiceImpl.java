package com.dm4x.components.service;

import com.dm4x.components.DAO.ComponentRepository;
import com.dm4x.components.entity.Component;
import com.dm4x.components.errorHandlers.ComponentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
