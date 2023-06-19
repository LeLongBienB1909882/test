package com.cantho.onetomany.Service;

import com.cantho.onetomany.Model.User;
import com.cantho.onetomany.Repository.AddressRepository;
import com.cantho.onetomany.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}
