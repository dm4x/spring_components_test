package com.kiselyov.components.service;

import com.kiselyov.components.entity.Version;

import java.util.List;

public interface VersionService {
    public List<Version> findAll();

    public Version findById(int theId);

    public void save(Version theVersion);

    public void deleteById(int theId);
}
