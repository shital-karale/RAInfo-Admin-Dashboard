package com.admin.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entities.FileInfo;

@Repository

public interface FileStrorageRepo extends JpaRepository<FileInfo, Integer> {

}
