package namdev.io.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import namdev.io.restapi.model.User;
import namdev.io.restapi.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	private List<User> users = new ArrayList<User>();
	
	
	@GetMapping()
	public List<User> getAll() {
		logger.info("===Information user===");
		return (List<User>) userService.findAll();
	}
	@PostMapping()
	public String create(@RequestBody User user) {
		try {
			userService.save(user);
			return "Add successful";
		} catch (Exception e) {
			return "Error";
		}
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		
			User user = userService.findOne(id);
			
			userService.delete(user);
			return "delete successful";			
		
	}
	@PutMapping()
	public String updateUser(@PathVariable(value = "id") Long id,@Valid @RequestBody User userDetails) {
		try {
			User user = userService.findOne(id);
			user.setName(userDetails.getName());
			user.setAge(userDetails.getAge());

			
			userService.save(user);
			return "Update successfuly";
		}catch (Exception e) {
			return "Error";
		}
	}
        
	@GetMapping("/user")
	public List<User> search(@RequestParam("s") String s) {
		return userService.search(s);
	}
}
