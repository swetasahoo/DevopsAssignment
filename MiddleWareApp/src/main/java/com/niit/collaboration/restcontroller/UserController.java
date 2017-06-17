package com.niit.collaboration.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserDao;
import com.niit.collaboration.model.User;

@RestController
public class UserController {
	
	@Autowired
	 UserDao userDAO;

	@Autowired
	 User user;
	
	//http://localhost:9006/MiddleWareApp/
	/*@RequestMapping(value="users",method=RequestMethod.GET)
	public ResponseEntity <List<User>> getAllUsers()
	{
		
		List<User> users=userDAO.list();
		for(User u:users)
		{
			System.out.println(u.getName());
			System.out.println(u.getEmail());
		}
		if(users.isEmpty())
		{
			System.out.println("user not available");
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}*/

	@GetMapping("/users")
	public List getUser() {
		
		return userDAO.list();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity getUser(@PathVariable("id") String id) {

		//Customer customer = customerDAO.get(id);
		System.out.println(id);
		User user=userDAO.get(id);
		if (user == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PostMapping(value = "/users")
	public ResponseEntity createuser(@RequestBody User user) {

		//customerDAO.create(customer);
		userDAO.save(user);

		return new ResponseEntity(user, HttpStatus.OK);
	}



}
