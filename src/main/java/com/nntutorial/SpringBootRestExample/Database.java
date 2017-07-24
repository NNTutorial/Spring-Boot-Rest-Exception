package com.nntutorial.SpringBootRestExample;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Database {
	
	private List<User> userlist=new ArrayList<>();
	
	@PostConstruct
	public void loadData() {
		userlist.add(new User(1,"Rajesh","Adobe"));
		userlist.add(new User(2,"Amit","IBM"));
		userlist.add(new User(3,"Rakesh","Oracle"));
		userlist.add(new User(4,"Raj","Micosoft"));
		userlist.add(new User(5,"Sam","Adobe"));
	}
	
	public List<User> getAllUsersList(){
		return userlist;
	}
	
	public List<User> getAllUsersByCompanyName(String companyname) throws CompanyNotFoundException{
		List<User> userListFiltered=new ArrayList<>();
		boolean flag=false;
		for(User user:getUserlist()) {
			if(user.getUsercompanyname().equalsIgnoreCase(companyname)) {
				userListFiltered.add(user);
				flag=true;
			}
		}
		
		if(!flag) {
			//userListFiltered.add(new User());
			throw  new CompanyNotFoundException();
		}
		return userListFiltered;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	
	

}
