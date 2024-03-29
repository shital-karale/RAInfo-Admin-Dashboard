package com.admin.controller;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.admin.entities.FileInfo;
import com.admin.service.FileStorageImpl;
import com.admin.service.FileStrorageRepo;

import jakarta.servlet.http.HttpSession;




@Controller
public class UploadImgController {
	
	@Autowired
	private FileStrorageRepo fileStorageRepo;
	@Autowired
	private FileStorageImpl fileStorageImpl;
	
	 
    // @GetMapping annotation for
    // mapping HTTP GET requests onto
    // specific handler methods. */
    @GetMapping("/img")
    public String getData(Model model) {
    	List<FileInfo> imglist=fileStorageImpl.getAllImgs();
    	model.addAttribute("list",imglist);
        return "inventory";
    }
   
    // @PostMapping annotation maps HTTP POST
    // requests onto specific handler methods
    @PostMapping("/upload_img")
    public String uploadMultipartFile(@RequestParam MultipartFile file, HttpSession session) throws IOException {
    	
    	FileInfo fileinfo=new FileInfo();
   
    	fileinfo.setImgname(file.getOriginalFilename());
    	FileInfo saveimg=fileStorageRepo.save(fileinfo);
    	
    	//System.out.println(saveimg);
    	
    	if(saveimg!=null) {
    		try {
    			
    			File filesave=new ClassPathResource("static/img").getFile();
    			Path path=Paths.get(filesave.getAbsolutePath()+File.separator+file.getOriginalFilename());
    			Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
    			
    		}catch(Exception e) {
    		e.printStackTrace();
    		}
    	}
       
    	session.setAttribute("msg","Image uploded successfully");
       
        return "redirect:/img";
    }
    
    // @PostMapping annotation maps HTTP POST
    // requests onto specific handler methods
    @PostMapping("/upload_vedio")
    public String uploadVideoFile(@RequestParam MultipartFile file, HttpSession session) throws IOException {
    	
    	FileInfo fileinfo=new FileInfo();
   
    	fileinfo.setVideofile(file.getOriginalFilename());
    	FileInfo saveimg=fileStorageRepo.save(fileinfo);
    	
    	//System.out.println(saveimg);
    	
    	if(saveimg!=null) {
    		try {
    			
    			File filesave=new ClassPathResource("static/img").getFile();
    			Path path=Paths.get(filesave.getAbsolutePath()+File.separator+file.getOriginalFilename());
    			Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
    			
    		}catch(Exception e) {
    		e.printStackTrace();
    		}
    	}
       
    	session.setAttribute("msg","Image uploded successfully");
       
        return "redirect:/img";
    }
	
    
    @GetMapping("/deleteimg/{id}")
	public String deleteproj(@PathVariable int id) {
    	fileStorageRepo.deleteById(id);   
        return "redirect:/img";
    	
    }
 

	
//    @GetMapping("/")
//    public String index() {
//        return "uploadform";
//    }
//    
//    @PostMapping("/upload_files")
//    public String uploadMultipartFile1(@RequestParam("files") MultipartFile[] files, Model model) {
//    	List fileNames = null;
//    	
//		try {
//	        fileNames = 
//	                
//	                	return file.getOriginalFilename();
//	                })
//	                .collect(Collectors.toList());
//			
//			model.addAttribute("message", "Files uploaded successfully!");
//			model.addAttribute("files", fileNames);
//		} catch (Exception e) {
//			model.addAttribute("message", "Fail!");
//			model.addAttribute("files", fileNames);
//		}
//		
//        return "uploadform";
//    }*/
//    
}


