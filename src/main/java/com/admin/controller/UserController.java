package com.admin.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.dao.ProjService;
import com.admin.entities.FileInfo;
import com.admin.entities.ProjectEntity;
import com.admin.service.FileStorageImpl;
import com.admin.service.FileStrorageRepo;

@Controller
//@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private ProjService service;
	@Autowired
	private FileStrorageRepo fileStorageRepo ;
	@Autowired
	private FileStorageImpl fileStorageImpl;
	
	   private static String UPLOADED_FOLDER =
		         "C:\\Users\\admin\\Desktop\\desktop\\SpringBootProj\\Files\\";

	
	@RequestMapping("/index")
	public String home(Model model) {
		 List<String> list = new ArrayList<String>();
	      File files = new File(UPLOADED_FOLDER);
	      String[] fileList = ((File) files).list();
	      for (String name : fileList) {
	         list.add(name);
	      }
		 model.addAttribute("list", list);
		List<ProjectEntity> proj=service.getAllProj();
		model.addAttribute("proj",proj);
		return "user/index";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
	 	List<FileInfo> imglist=fileStorageImpl.getAllImgs();
    	model.addAttribute("imglist",imglist);
		
		return "user/about";
	}
	@RequestMapping("/service")
	public String service(Model model) {
		
		
		return "user/service";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		
		
		return "user/contact";
	}
	@RequestMapping("/career")
	public String career(Model model) {
		
		
		return "user/career";
	}
	
	 @RequestMapping("/gallery")
		public String gallery(Model model) {
		 	List<FileInfo> imglist=fileStorageImpl.getAllImgs();
	    	model.addAttribute("imglist",imglist);
			
			return "user/gallery";
		}
	

}
