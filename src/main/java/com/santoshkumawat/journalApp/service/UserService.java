package com.santoshkumawat.journalApp.service;

import com.santoshkumawat.journalApp.entity.JournalEntry;
import com.santoshkumawat.journalApp.entity.User;
import com.santoshkumawat.journalApp.repository.JournalEntryRepository;
import com.santoshkumawat.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public Optional<User> findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById(ObjectId id){
        userRepository.deleteById(id);
    }

    public void deleteByUserName(String userName){
        userRepository.deleteByUserName(userName);
    }
}
