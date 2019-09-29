package com.kiselyov.components.service;

import com.kiselyov.components.DAO.VersionRepository;
import com.kiselyov.components.entity.Version;
import com.kiselyov.components.errorHandlers.VersionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionServiceImpl implements VersionService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private VersionRepository versionRepository;

    @Autowired
    public VersionServiceImpl(VersionRepository theVersionRepository){
        this.versionRepository = theVersionRepository;
    }
    @Override
    public List<Version> findAllVersions() {
        logger.debug("findAllVersions called");
        return versionRepository.findAll();
    }

    @Override
    public Version findVersionById(int theId) {
        logger.debug("findVersionById called");
        Optional<Version> result = versionRepository.findById(theId);

        Version theVersion = null;
        if(result.isPresent()) {
            theVersion = result.get();
        }
        else {
            throw new VersionNotFoundException();
        }

        return theVersion;

    }

    @Override
    public void saveVersion(Version theVersion) {
        logger.debug("saveVersion called");
        versionRepository.save(theVersion);
    }

    @Override
    public void deleteVersionById(int theId) {
        logger.debug("deleteVersionById called");
        versionRepository.deleteById(theId);
    }
}
