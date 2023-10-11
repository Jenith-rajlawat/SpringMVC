package com.mvc.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.root.model.User;

public interface UserRepository extends JpaRepository<User, Integer	>{

	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);

}
