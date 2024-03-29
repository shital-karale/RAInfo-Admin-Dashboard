
package com.admin.service;



import java.io.IOException;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.admin.entities.FileInfo;

@Service
public class FileStorageImpl implements  FileStorage{
	
	@Autowired
	private FileStrorageRepo filestorageRepo;
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("filestorage");
 

	 @Override
	    public List<FileInfo> getAllImgs() {
	        // fetch all the files form database
	        return filestorageRepo.findAll();
	    }
	 @Override
	    public void saveAllFilesList(List<FileInfo> fileList) {
	        // Save all the files into database
	        for (FileInfo fileinfo : fileList)
	        	filestorageRepo.save(fileinfo);
	    }
	
	
    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
            	throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
        	throw new RuntimeException("Error! -> message = " + e.getMessage());
        }
    }
    
	
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

	
//    public void init() {
//        try {
//            Files.createDirectory(rootLocation);
//        } catch (IOException e) {
//            throw new RuntimeException("Could not initialize storage!");
//        }
//    }
//
//	
//	public Stream loadFiles() {
//        try {
//            return Files.walk(this.rootLocation, 1)
//                .filter(path -> !path.equals(this.rootLocation))
//                .map(this.rootLocation::relativize);
//        }
//        catch (IOException e) {
//        	throw new RuntimeException("\"Failed to read stored file");
//        }
//	}
//	
	
}
