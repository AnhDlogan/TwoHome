package com.example.twohome.service;


import com.example.twohome.entity.User;
import com.example.twohome.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService extends CRUDService<User, Long>{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(User.class);
        this.repository = this.userRepository = userRepository;
    }

    @Override
    public Event create(User user) {
        User checkUser = userRepository.findFirstByEmail(user.getEmail());
        if (checkUser != null) {
            return HandleErrorMessage("duplicate email");
        }
    }
//
//    public List<User> getFull() {
//        return userRepository.findAll();
//    }
//
//    public User get(Long id) {
//        return userRepository.findFirstById(id);
//    }
}
