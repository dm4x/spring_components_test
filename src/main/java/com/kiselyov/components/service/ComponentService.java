package com.kiselyov.components.service;

import com.kiselyov.components.entity.Component;

import java.util.List;

public interface ComponentService {
    List<Component> findAllComponents();

    Component findComponentById(int theId);

    void saveComponent(Component theComponent);

    void deleteComponentById(int theId);
}
