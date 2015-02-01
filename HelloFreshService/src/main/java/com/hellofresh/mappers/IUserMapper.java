package com.hellofresh.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hellofresh.model.User;

@Repository("userMapper")
public interface IUserMapper {
	
	@Select("SELECT password FROM account WHERE username = #{0}")
	public String selectUser(String userName);

}
