package com.customermanagement.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customermanagement.app.entity.Customer;
import com.customermanagement.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping(value="/getAllCustomers", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getById/{id}")
	public Customer findCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/getByContactNo/{contactNo}")
	public Customer findCustomerByContactNo(@PathVariable String contactNo) {
		return customerService.getCustomerByContactNo(contactNo);
	}
	
	@GetMapping("/getByAge/{age}")
	public List<Customer> findCustomerByAge(@PathVariable int age) {
		return customerService.getCustomerByAge(age);
	}
}
