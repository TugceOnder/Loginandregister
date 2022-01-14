package com.app.registration.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.User;

public interface RegistrationReporsitory extends JpaRepository<User,Integer>{
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId,String password);

}
