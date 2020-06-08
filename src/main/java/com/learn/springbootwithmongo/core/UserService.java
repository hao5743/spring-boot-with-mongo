package com.learn.springbootwithmongo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public long count() {
       return userRepository.count();
    }

    public void add(String name, String remark) {
        userRepository.save(new User(name, remark));
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public Page<User> list(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Page<User> findByName(String name, Pageable pageable) {
        return userRepository.findByName(name, pageable);
    }

    public Page<User> queryByNameAndRemark(String name, String remark, Pageable pageable) {
        System.out.println("name:" + name + "remark: " + remark);
        return userRepository.queryByNameAndRemark(name, remark, pageable);
    }

    public static void main(String[] args) {
    }
}
