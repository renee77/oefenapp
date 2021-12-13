package com.eva.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eva.app.model.User;
import com.eva.app.service.UserService;



@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping ("/user")
public class UserRest {

	private UserService userService;

	@Autowired
	public UserRest(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping (path = "/add")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@GetMapping (path = "/show")
	public List<User> showUsers(){
		return userService.showUsers();
	}
	
	@DeleteMapping (path = "/remove/{id}")
	public void removeUser(@PathVariable long id) {
		userService.removeUser(id);
	}
	
	@PutMapping(path = "/update/{id}")
	public void updateUser(@PathVariable long id, @RequestBody User user) {
		userService.updateUser(id, user.getName(), user.getAge());
	}
	
//	public void updateUser2(@RequestBody User user, @PathVariable long id) {
//		Optional<User> optinalUser = userService.findById(id);
//		if (optinalUser.isPresent()) {
//			User updateUser = optinalUser.get();
//			updateUser.setName(user.getName());
//			updateUser.setAge(user.getAge());
//			userService.updateUser2(updateUser);
//		}
//	}
//	
	
}
