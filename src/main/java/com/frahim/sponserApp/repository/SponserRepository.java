package com.frahim.sponserApp.repository;

import com.frahim.sponserApp.entity.SponserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponserRepository extends JpaRepository<SponserEntity, Long> {
    //All CRUD methods for Database
}
