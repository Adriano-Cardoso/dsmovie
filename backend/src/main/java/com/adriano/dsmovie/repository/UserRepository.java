package com.adriano.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adriano.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	User findByEmail(String email);

}
