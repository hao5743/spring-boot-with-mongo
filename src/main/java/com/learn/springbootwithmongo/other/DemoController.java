package com.learn.springbootwithmongo.other;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     * get 解析 path param
     */
    @RequestMapping(value="/hello/{name}", method = RequestMethod.GET)
    public String say(@PathVariable("name") String name) {
        return "hello: " + name;
    }

    /**
     * get 解析 query param
     */
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String say2(@RequestParam("name") String name) {
        return "hello from query: " + name;
    }
}
