package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
