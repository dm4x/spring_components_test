package com.kiselyov.components.DAO;

import com.kiselyov.components.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Integer> {
}
