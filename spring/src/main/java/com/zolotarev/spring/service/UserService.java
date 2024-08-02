package com.zolotarev.spring.service;

import com.zolotarev.spring.entity.UserEntity;
import com.zolotarev.spring.exceptions.UserAlreadyExistException;
import com.zolotarev.spring.exceptions.UserNotFoundException;
import com.zolotarev.spring.model.User;
import com.zolotarev.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User already exist");
        }
        return userRepository.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) throws UserNotFoundException {
        userRepository.deleteById(id);
        return id;
    }
}
