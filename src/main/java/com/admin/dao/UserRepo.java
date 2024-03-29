package com.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entities.ProjectEntity;

public interface UserRepo extends JpaRepository<ProjectEntity,Integer>{

}
