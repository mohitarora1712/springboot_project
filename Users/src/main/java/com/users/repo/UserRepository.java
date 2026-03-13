package com.users.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.users.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}

