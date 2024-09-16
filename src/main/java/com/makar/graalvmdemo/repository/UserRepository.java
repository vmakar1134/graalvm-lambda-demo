package com.makar.graalvmdemo.repository;

import com.makar.graalvmdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
