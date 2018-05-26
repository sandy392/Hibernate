package com.Login.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Login.entity.User;
import com.Login.service.IUserServiceImpl;

@RestController
@RequestMapping("/login")
public class UserController {

	@Autowired
	private IUserServiceImpl service;

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public List<User> getUsers() {
		return service.getUsers();
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, produces = { "application/json"})
	public User getUserById(@PathVariable("userId") String userId) {
		return service.getUser(userId);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = { "application/json", "application/xml" })
	public User createUser(@Valid @RequestBody User user) {

		return service.createUser(user);

	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public User updateUser(@PathVariable("userId") String userId, @Valid @RequestBody User user) {
		return service.updateUser(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public ResponseEntity<User> deleteUser(@PathVariable("userId") String userId) {
		User user = service.getUser(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		service.deleteUser(user);
		return ResponseEntity.ok().build();
	}

}
