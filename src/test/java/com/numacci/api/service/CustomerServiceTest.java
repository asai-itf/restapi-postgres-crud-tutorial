package com.numacci.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.numacci.api.dto.Customer;
import com.numacci.api.repository.CustomerMapper;
import com.numacci.api.service.impl.CustomerServiceImpl;

public class CustomerServiceTest {
	
	@Mock
	private CustomerMapper mapper;
	
	@InjectMocks
	private CustomerServiceImpl service;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@DisplayName("CREATE TEST: check if registeration succeeded.")
	@Test
	public void testResister() {
		Customer customer = new Customer();
	    customer.setId("100");
	    customer.setUsername("user100");
	    customer.setEmail("test.user.100@EXAMPLE.com");
	    customer.setPhoneNumber("01234567890");
	    customer.setPostCode("1234567");

	    when(mapper.insert(Mockito.any(Customer.class))).thenReturn(1);
	    Customer actual = service.register(customer);
	    assertEquals(customer.getId(), actual.getId());
	    assertEquals(customer.getUsername(), actual.getUsername());
	    assertEquals("test.user.100@example.com", actual.getEmail());
	    assertEquals(customer.getPhoneNumber(), actual.getPhoneNumber());
	    assertEquals(customer.getPostCode(), actual.getPostCode());
	    Mockito.verify(mapper, Mockito.times(1)).insert(customer);
	}

}
