package com.learn.springbootwithmongo;

import com.learn.springbootwithmongo.core.User;
import com.learn.springbootwithmongo.core.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * created by shaochong.com on 12:09 下午 2020/6/4
 */

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMongoTests {
    @Autowired
    UserRepository userRepository;
    @Test
    public void contextLoads() {
        userRepository.save(new User("嘻嘻","这只是个备注"));
        List<User> list = userRepository.findAll();
        System.out.println(list);
        System.out.println("size:  " + list.size());
        for(User u : list) {
            System.out.println(u.getId() + u.getName());
        }
    }
    @Before
    public void before(){
        System.out.print("开始进行MongoDB测试");
    }
    @After
    public void after(){
        System.out.print("结束测试！");
    }


}