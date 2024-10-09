package com.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByEmailAndConfirmPwd(String email,String confirmPwd);
	
	public Optional<User> findByEmail(String email);
}
