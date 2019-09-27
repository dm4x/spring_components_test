package com.dm4x.components.service;

import com.dm4x.components.entity.Responsible;

import java.util.List;

public interface ResponsibleService {
    public List<Responsible> findAll();

    public Responsible findById(int theId);

    public void save(Responsible theResponsible);

    public void deleteById(int theId);
}
