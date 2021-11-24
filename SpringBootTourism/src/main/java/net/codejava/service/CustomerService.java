package net.codejava.service;

import java.util.List;

import net.codejava.entity.Customer;

public interface CustomerService {

	List<Customer> getAllCustomer();

	Customer getcustomerById(Long id);

	Customer updateCustomer(Customer customer);

	Customer getCustomerById(Long id);

	void deleteCustomerById(Long id);

}
