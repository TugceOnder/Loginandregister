package com.app.registration.controller;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationSevice;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationSevice service;
	@PostMapping("/registeruser") // register kýsmýný bu url kullanarak çagýrcagýz
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user ) throws Exception {
		
		String tempEmailId=user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			//service.fetchUserByEmailId(tempEmailId); //email kayýtlý mý degil mi  bos bu degil miona bakýp kontrol ediyor
			User userObj =service.fetchUserByEmailId(tempEmailId);
			if(userObj != null) {
				throw new Exception("user with"+ tempEmailId+"is already exist");
				
			}
		}
		User userObj = null; 
		userObj = service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String temPass = user.getPassword();
		
		User userObj =null;
		if(tempEmailId != null && temPass != null) {
			userObj=  service.fetchUserByEmailIdAndPassword(tempEmailId, temPass);
		}
		
		if(userObj == null) {
		
			throw new Exception	("Bad credentials");
		}
		return userObj;
	}

}
