package com.admin.controller;

import java.io.IOException;

import java.net.http.HttpClient.Redirect;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.dao.ProjRepo;
import com.admin.dao.ProjService;
import com.admin.entities.FileInfo;
import com.admin.entities.ProjectEntity;
import com.admin.service.FileStorageImpl;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeContr {
	
	@Autowired
	private ProjService service;
	@Autowired
	private FileStorageImpl fileStorageImpl;

	@Autowired
	private ProjRepo service1 ;
	
	@GetMapping("/")
	public String getHome()
	{
		return "home";
	}
	
	@GetMapping("/inve")
	public String getinventory()
	{
		return "inventory";
	}
	  
	
	@RequestMapping("/login")
	public String customLogin(Model model)
	{
		return "login";
	}
	
	@RequestMapping("/addpro")
	public String addProj(Model model)
	{
		return "project";
	}
	@RequestMapping("/list")
	public String listProj(Model model)
	{
		return "projlist";
	}
	
	@GetMapping("/projdetials")
	public String allProj(Model model)
	
	{
		List<ProjectEntity> proj=service.getAllProj();
		model.addAttribute("proj",proj);
		return "projectdetials";
	}
	
	@PostMapping("/saveproj")
	public String saveProj(@ModelAttribute ProjectEntity proj)
	
	{ 
		System.out.println(proj);
		service.addProj(proj);
		return "redirect:/projdetials";
	}
	
	@RequestMapping("/edit/{id}")
	public String editProj(@PathVariable int id,Model m)
	
	{
		ProjectEntity proj=service.getProjById(id);
		m.addAttribute("proj", proj);
		return "edit";
	}
	@PostMapping("/updateproj")
	public String updateProj(@ModelAttribute ProjectEntity proj)
	
	{ 
		
		service.addProj(proj);
		return "redirect:/projdetials";
	}
	@GetMapping("/delete/{id}")
	public String deleteproj(@PathVariable int id) {
		service.deleteBYId(id);
		return "redirect:/projdetials";
		
	}
	
}
	
	//Inventory part uploading doc pdf jpg
	/*@GetMapping("/inven")
	public String inven() {
		return "uploadfile";
	}
	
	@PostMapping("/fileupload")
	public String uploadfile(@RequestParam("file") MultipartFile file,Model model)throws IOException{
		
		FileData filedata=new FileData();
		String filename=file.getOriginalFilename();
		filedata.setProfile(filename);
		filedata.setContent(file.getBytes());
		filedata.setSize(file.getSize());
		fservice.createFileData(filedata);
		model.addAttribute("success","file uplaoded successfully");
		return "inventory";
	}
	
	@GetMapping("/download")
	public void downloadFile(@Param("id") int id, HttpServletResponse response) throws IOException {
		Optional<FileData> temp=fservice.findFileDataById(id);
		if(temp==null) {
			FileData filedata=temp.get();
			response.setContentType("application/octet-stream");
			String headerKey="content-Disposition";
			String headerVaule="attachment; fiename= "+filedata.getProfile();
			response.setHeader(headerKey, headerVaule);
			ServletOutputStream outputstream= response.getOutputStream();
			outputstream.write(filedata.getContent());
			outputstream.close();
		}
	}
	
	@GetMapping("/content")
	public void showImg(@Param("id")int id,HttpServletResponse response,Optional<FileData> filedata) throws IOException {
		
		filedata=fservice.findFileDataById(id);
		response.setContentType("image/jpg,image/png,image/gif,image/pdf");
		response.getOutputStream().write(filedata.get().getContent());
		response.getOutputStream().close();
	}
}*/








