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

import com.hellofresh.model.Vegetable;
import com.hellofresh.service.IUserService;
import com.hellofresh.service.IVegetableService;

@Controller
@RequestMapping("/vegetable")
public class VegetableController {
	
	
	@Autowired
    @Qualifier("vegetableService")
    private IVegetableService vegetableService;
	
	@RequestMapping(value = "/search", method = {RequestMethod.GET})
	@ResponseBody
	public  Vegetable userLogin(@RequestParam(value = "vegetable_name") String vegetableName) {
		
		Vegetable vegetable = vegetableService.searchVegetableByName(vegetableName);
		return vegetable;
	}

}
