package com.nntutorial.SpringBootRestExample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public Database database;
	
	@RequestMapping(value="/getallusers",method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return database.getAllUsersList();
	}
	
	@RequestMapping(value="/getusers/{companyname}",method=RequestMethod.GET)
	public List<User> getUsersByCompanyName(@PathVariable String companyname) throws CompanyNotFoundException{
		return database.getAllUsersByCompanyName(companyname);
	}
	
	@ExceptionHandler(CompanyNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String invalidCompany(Exception e) {
		return e.getMessage();
	}

}
