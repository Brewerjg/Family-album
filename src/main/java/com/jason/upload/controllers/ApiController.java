package com.jason.upload.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.upload.models.Image;
import com.jason.upload.repositories.ImageRepository;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping(path="/api")
public class ApiController {
	


	@Autowired
	private ImageRepository repo;
	
	@GetMapping(value="/image")
		public List<Image> getImage(){
			return repo.findAll();
	}
	
	@GetMapping(value="/image/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public Image getOneImage(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}
	
	
	@PostMapping(value="/image/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Image createImage (@RequestBody Image image) {
		return repo.save(image);
	}
	
	@PutMapping(value="/image/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Image editImage (@PathVariable Long id, @RequestBody Image image) {
		Image I = repo.findById(id).orElse(null);
		I = image;
		I.setId(id);
		return repo.save(I);
	}
	
	@DeleteMapping("/image/{id}")
	public String deleteImage(@PathVariable Long id) {
		repo.deleteById(id);
		return "Image Deleted";
	}
	    
	    
}
