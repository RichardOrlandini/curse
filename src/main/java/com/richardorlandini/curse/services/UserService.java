package com.richardorlandini.curse.services;

import com.richardorlandini.curse.entities.User;
import com.richardorlandini.curse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //spring vai instanciar automaticamene fazendo a injecão da dependencia
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
       Optional<User> obj = repository.findById(id);
       return obj.get();//retornando um obj do tipo user
    }

    public User insert(User obj){
       return repository.save(obj); // o salve por padrão retorna um obj salvo
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id); // o getReferenceById serve instanciar um obj, para trabalharmos e depois efetuarmos uma operação no bd
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }

}
