package com.lpu.test2.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.test2.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Long>{

    Optional<AppUser> findByUsername(String username);

}