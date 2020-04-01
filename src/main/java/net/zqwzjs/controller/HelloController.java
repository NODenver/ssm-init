package net.zqwzjs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ssm-init
 * @author: Mr.Zi
 * @create: 2020-04-01 16:23
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
