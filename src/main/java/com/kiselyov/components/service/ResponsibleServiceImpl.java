package com.kiselyov.components.service;

import com.kiselyov.components.DAO.ResponsibleRepository;
import com.kiselyov.components.entity.Responsible;
import com.kiselyov.components.errorHandlers.ResponsibleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsibleServiceImpl implements ResponsibleService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ResponsibleRepository responsibleRepository;

    @Autowired
    public ResponsibleServiceImpl(ResponsibleRepository theResponsibleRepository) {
        responsibleRepository = theResponsibleRepository;
    }

    @Override
    public List<Responsible> findAllResponsibles() {
        logger.debug("findAllResponsibles called");
        return responsibleRepository.findAll();
    }

    @Override
    public Responsible findResponsibleById(int theId) {
        logger.debug("findResponsibleById called");
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
    public void saveResponsible(Responsible theResponsible) {
        logger.debug("saveResponsible called");
        responsibleRepository.save(theResponsible);
    }

    @Override
    public void deleteResponsibleById(int theId) {
        logger.debug("deleteResponsibleById called");
        responsibleRepository.deleteById(theId);
    }
}
