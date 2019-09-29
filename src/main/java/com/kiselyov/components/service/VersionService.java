package com.kiselyov.components.service;

import com.kiselyov.components.entity.Version;

import java.util.List;

public interface VersionService {
    List<Version> findAllVersions();

    Version findVersionById(int theId);

    void saveVersion(Version theVersion);

    void deleteVersionById(int theId);
}
