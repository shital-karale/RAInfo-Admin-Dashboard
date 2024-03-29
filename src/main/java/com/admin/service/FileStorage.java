package com.admin.service;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
 
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.admin.entities.FileInfo;
import com.admin.entities.ProjectEntity;
 
public interface FileStorage {
	
	public List<FileInfo> getAllImgs();
	
	void saveAllFilesList(List<FileInfo> fileList);
	//public Resource loadFile(String filename);
	
		
	
	public void deleteAll();
	//public void init();
	//public Stream<Path> loadFiles();
}
