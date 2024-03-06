package com.gefersonholdorf.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gefersonholdorf.workshopmongo.dtos.UserDTO;
import com.gefersonholdorf.workshopmongo.entities.User;
import com.gefersonholdorf.workshopmongo.repositories.UserRepository;
import com.gefersonholdorf.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return listDto;
    }

    public UserDTO findById(String id) {
        Optional<User> obj = repository.findById(id);
        User user = obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return new UserDTO(user);
    }

    public UserDTO insert(UserDTO obj) {
        User user = fromDTO(obj);
        user = repository.save(user);

        return new UserDTO(user);
    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
    
}
