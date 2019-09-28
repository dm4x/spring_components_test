package com.kiselyov.components.DAO;

import com.kiselyov.components.entity.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsibleRepository extends JpaRepository<Responsible, Integer> {
}
