package com.gefersonholdorf.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gefersonholdorf.workshopmongo.dtos.UserDTO;
import com.gefersonholdorf.workshopmongo.entities.User;
import com.gefersonholdorf.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return listDto;
    }
    
}
