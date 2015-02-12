package com.hellofresh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hellofresh.mappers.IUserMapper;
import com.hellofresh.mappers.IVegetableMapper;
import com.hellofresh.model.Vegetable;
import com.hellofresh.service.IVegetableService;

@Service("vegetableService")
public class VegetableService implements IVegetableService {
	
	@Autowired
    @Qualifier("vegetableMapper")
    private IVegetableMapper vegetableMapper;

	@Override
	public Vegetable searchVegetableByName(String vegetableName) {
		// TODO Auto-generated method stub
		return vegetableMapper.selectVegetableByName(vegetableName);
	}

}
