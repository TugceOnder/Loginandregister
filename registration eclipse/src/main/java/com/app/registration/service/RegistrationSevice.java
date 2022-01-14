package com.app.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.User;
import com.app.registration.reporsitory.RegistrationReporsitory;


@Service
public class RegistrationSevice {

	@Autowired
	private RegistrationReporsitory repo;
	public User saveUser(User user ) {
		return repo.save(user); //kullanýclarý database (veritabanýna ) kaydediyor 
		
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}
}
