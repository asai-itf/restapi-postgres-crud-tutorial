package com.numacci.api.service.impl;

import org.springframework.stereotype.Service;

import com.numacci.api.dto.Customer;
import com.numacci.api.repository.CustomerMapper;
import com.numacci.api.service.CustomerService;

@Service
public class CustomerServiceImpl  implements CustomerService{
	
	private CustomerMapper mapper;
	
	public CustomerServiceImpl(CustomerMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public Customer register(Customer customer) {
		String formattedEmail = formatEmail(customer.getEmail());
		customer.setEmail(formattedEmail);
		
		mapper.insert(customer);
		return customer;
	}
	
	private String formatEmail(String email) {
		String[] separatedEmail = email.split("@");
		return separatedEmail[0] + "@" + separatedEmail[1].toLowerCase();
	}

}
