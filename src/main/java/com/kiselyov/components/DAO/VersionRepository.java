package com.kiselyov.components.DAO;

import com.kiselyov.components.entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Integer> {
}
