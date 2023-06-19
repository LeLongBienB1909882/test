package com.cantho.onetomany.Controller;

import com.cantho.onetomany.Model.Address;
import com.cantho.onetomany.Model.User;
import com.cantho.onetomany.Repository.AddressRepository;
import com.cantho.onetomany.Repository.UserRepository;
import com.cantho.onetomany.Service.AddressService;
import com.cantho.onetomany.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @PostMapping()
    public User addUserandAddress(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping()
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
