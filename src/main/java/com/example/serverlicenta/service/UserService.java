package com.example.serverlicenta.service;

import com.example.serverlicenta.entity.Order;
import com.example.serverlicenta.entity.User;
import com.example.serverlicenta.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private IUserRepository userRepository;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser (User u){
        return userRepository.save(u);
    }
    public void remove(Long id) {
        try{
            User u=userRepository.getOne(id);
            userRepository.delete(u);
        }catch (Exception e){

        }
    }
    public User getOneById(Long id) {
        return userRepository.getOne(id);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

}
