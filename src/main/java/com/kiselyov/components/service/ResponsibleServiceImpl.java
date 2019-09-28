package com.kiselyov.components.service;

import com.kiselyov.components.DAO.ResponsibleRepository;
import com.kiselyov.components.entity.Responsible;
import com.kiselyov.components.errorHandlers.ResponsibleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsibleServiceImpl implements ResponsibleService{

    private ResponsibleRepository responsibleRepository;

    @Autowired
    public ResponsibleServiceImpl(ResponsibleRepository theResponsibleRepository) {
        responsibleRepository = theResponsibleRepository;
    }

    @Override
    public List<Responsible> findAll() {
        return responsibleRepository.findAll();
    }

    @Override
    public Responsible findById(int theId) {
        Optional<Responsible> result = responsibleRepository.findById(theId);

        Responsible theResponsible = null;
        if(result.isPresent()) {
            theResponsible = result.get();
        }
        else {
            throw new ResponsibleNotFoundException();
        }

        return theResponsible;

    }

    @Override
    public void save(Responsible theResponsible) {
        responsibleRepository.save(theResponsible);
    }

    @Override
    public void deleteById(int theId) {
        responsibleRepository.deleteById(theId);
    }
}
