package com.project.npp.service;

import java.util.List;
import java.util.Optional;

import com.project.npp.entities.ERole;
import com.project.npp.entities.Role;
import com.project.npp.entities.UserEntity;

public interface UserEntityService {

	// Add user
	public UserEntity addUserEntity(UserEntity user);

	// Get user
	public UserEntity getUserEntity(String username);
	
	// Update role
	public String updateRole(String username, Role role);

	// Find by user name
	public Optional<UserEntity> findByUsername(String username);

	// Exists by user name
	public Boolean existsByUsername(String username);

	// Find by role
	public Optional<UserEntity> findByRole(ERole role);

	// Get all users
	public List<UserEntity> getAllUserEntities();
}
