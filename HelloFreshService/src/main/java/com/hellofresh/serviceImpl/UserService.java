package com.hellofresh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hellofresh.mappers.IUserMapper;
import com.hellofresh.model.User;
import com.hellofresh.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	
	@Autowired
    @Qualifier("userMapper")
    private IUserMapper userMapper;
	
	@Override
	public String selectUserPassword(String userName) {
		
		String user = userMapper.selectUser(userName);
	//	System.out.println(user.getUserName());
		return user;
		
	}

}
