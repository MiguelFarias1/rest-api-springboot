package com.nelio.udemy.project.repositories;

import com.nelio.udemy.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
