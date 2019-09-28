package com.kiselyov.components.service;

import com.kiselyov.components.DAO.VersionRepository;
import com.kiselyov.components.entity.Version;
import com.kiselyov.components.errorHandlers.VersionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionServiceImpl implements VersionService{
    private VersionRepository versionRepository;

    @Autowired
    public VersionServiceImpl(VersionRepository theVersionRepository){
        this.versionRepository = theVersionRepository;
    }
    @Override
    public List<Version> findAll() {
        return versionRepository.findAll();
    }

    @Override
    public Version findById(int theId) {
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
    public void save(Version theVersion) {
        versionRepository.save(theVersion);
    }

    @Override
    public void deleteById(int theId) {
        versionRepository.deleteById(theId);
    }
}
