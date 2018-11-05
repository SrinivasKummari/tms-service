package com.srinivas.tms.tmsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srinivas.tms.tmsservice.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
