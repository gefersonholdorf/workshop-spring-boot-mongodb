package com.gefersonholdorf.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.workshopmongo.dtos.UserDTO;
import com.gefersonholdorf.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
