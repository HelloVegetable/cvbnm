package com.hellofresh.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public  Map<String, String> userLogin(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		
		String password2 = userService.selectUserPassword(userName);
		Map<String,String> map = new HashMap<String, String>();
		JSONObject object = new JSONObject();
		if(password2.equals(password)){
		    map.put("login", "true");
		}else{
			map.put("login", "false");
		}
			return map;	
	
	}

}
