package com.hellofresh.mappers;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import com.hellofresh.model.Vegetable;

@Repository("vegetableMapper")
public interface IVegetableMapper {
	
	@Select("Select * FROM vegetable WHERE english_name = #{0}")
    @Results(
            value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "description", column = "description"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "englishName", column = "english_name")
            })
	public Vegetable selectVegetableByName(String vegetableName);

}
