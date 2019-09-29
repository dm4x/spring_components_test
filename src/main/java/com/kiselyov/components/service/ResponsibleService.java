package com.kiselyov.components.service;

import com.kiselyov.components.entity.Responsible;

import java.util.List;

public interface ResponsibleService {
    List<Responsible> findAllResponsibles();

    Responsible findResponsibleById(int theId);

    void saveResponsible(Responsible theResponsible);

    void deleteResponsibleById(int theId);
}
