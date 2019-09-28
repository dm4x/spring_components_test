package com.kiselyov.components.service;

import com.kiselyov.components.entity.Component;

import java.util.List;

public interface ComponentService {
    public List<Component> findAll();

    public Component findById(int theId);

    public void save(Component theComponent);

    public void deleteById(int theId);
}
