package com.example.twohome.service;


import com.example.twohome.model.User;
import com.example.twohome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getFull() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.findFirstById(id);
    }
}
