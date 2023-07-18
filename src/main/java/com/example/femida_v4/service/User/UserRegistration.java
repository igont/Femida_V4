package com.example.femida_v4.service.User;

import java.util.HashMap;
import java.util.Map;

public class UserRegistration
{
	private Map<String, User> allUsers = new HashMap<>();
	public User activeUser;
	
	public void register(User newUser)
	{
		if(!allUsers.containsKey(newUser.getName()))
		{
			allUsers.put(newUser.getName(), newUser);
		}
		activeUser = newUser;
	}
}
