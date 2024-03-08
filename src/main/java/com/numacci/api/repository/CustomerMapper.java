package com.numacci.api.repository;

import org.apache.ibatis.annotations.Mapper;

import com.numacci.api.dto.Customer;

@Mapper
public interface CustomerMapper {
	
	int insert(Customer customer);

}
