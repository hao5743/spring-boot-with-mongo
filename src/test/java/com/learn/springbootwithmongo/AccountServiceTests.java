package com.learn.springbootwithmongo;

import com.learn.springbootwithmongo.core2.Account;
import com.learn.springbootwithmongo.core2.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTests {
    @Autowired
    AccountService accountService;

    @Test
    public void contextLoads() {
        accountService.addAccount(new Account("liudehua", "N0000001", "第一个公司"));
        System.out.println("add success!");
        Account query = new Account("liudehua", "N0000001", "第一个公司");
        List<Account> list = accountService.query(query);
        System.out.println("query length: " + list.size());

        list = accountService.list();
        System.out.println("query length: " + list.size());

        list = accountService.query2(new Account("liudehua", "N0000001", "第一个公司"));
        System.out.println("query2 length: " + list.size());
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
