package com.learn.springbootwithmongo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public String getCount() {
        return "count: " + userService.count();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addOne(@RequestParam("name") String name, @RequestParam("remark") String remark) {
        userService.add(name, remark);
        return "ok, after add count: " + userService.count();
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll() {
        List<User> userList = userService.listAll();
        StringBuilder sb = new StringBuilder();
        for (User u : userList) {
            sb.append(u.toString()).append("\n");
        }
        return sb.toString();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list(@PageableDefault(page = 0, size = 10, sort = "name,asc")Pageable pageable) {
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        Page<User> pageUser = userService.list(pageable);
        List<User> userList = pageUser.getContent();
        return userList;
    }
    
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public List<User> findByName(@PageableDefault()Pageable pageable, @RequestParam("name") String name) {
        System.out.println("name: " + name);
        return userService.findByName(name, pageable).getContent();
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public List<User> query(@PageableDefault()Pageable pageable, 
                            @RequestParam("name")String name,
                            @RequestParam("remark")String remark
                            ) {
        System.out.println("name: " + name + "remark: " + remark);
        return userService.queryByNameAndRemark(name, remark, pageable).getContent();
    }
}
