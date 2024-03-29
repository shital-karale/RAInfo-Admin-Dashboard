package com.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entities.ProjectEntity;

@Repository

public interface ProjRepo extends JpaRepository<ProjectEntity,Integer> {

}
