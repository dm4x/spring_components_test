package com.dm4x.components.DAO;

import com.dm4x.components.entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Integer> {
}
