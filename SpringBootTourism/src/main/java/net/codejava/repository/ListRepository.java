package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.List;

public interface ListRepository extends JpaRepository<List, Long> {
	
	

}
