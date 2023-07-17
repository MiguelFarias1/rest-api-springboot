package com.nelio.udemy.project.resources;

import com.nelio.udemy.project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    public ResponseEntity<List<User>> findAll() {

        return ResponseEntity.ok().body(List.of(new User()));
    }
}
