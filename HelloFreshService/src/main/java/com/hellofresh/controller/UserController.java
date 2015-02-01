package com.hellofresh.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellofresh.model.User;
import com.hellofresh.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    @Qualifier("userService")
    private IUserService userService;
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET}, consumes = "*/*", produces = "application/json")
	@ResponseBody
	public  Object userLogin(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		
		String password2 = userService.selectUserPassword(userName);
		JSONObject object = new JSONObject();
		if(password2.equals(password)){
		    object.put("login", "true");
		}else{
			object.put("login", "false");
		}
			return object;	
	
	}

}
