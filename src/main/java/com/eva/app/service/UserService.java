package com.eva.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eva.app.model.User;
import com.eva.app.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//post
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	//get
	public List<User> showUsers(){
		return userRepository.findAll();
	}
	
	//delete
	public void removeUser(Long id) {
		if (userRepository.existsById(id))
		userRepository.deleteById(id);
	}
	
	//put (update)
	public void updateUser(Long id, String name, int age) {
// 		zoek het object
		Optional <User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
//			pas de velden aan
			User user = optionalUser.get();
			user.setAge(age);
			user.setName(name);
//			sla object op
			userRepository.save(user);
			System.out.println("User updated");
		} else {
			System.out.println("User not found wiht id: " + id);
		}
	
		
	}
	
//	public void updateUser2(User user) {
//		userRepository.save(user);
//	}
//	
//	public Optional<User> findById(long id) {
//		return userRepository.findById(id);
//	}
//	
	
	

}
