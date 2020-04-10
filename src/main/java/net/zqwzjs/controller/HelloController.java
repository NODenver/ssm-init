package net.zqwzjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ssm-init
 * @author: Mr.Zi
 * @create: 2020-04-01 16:23
 **/
@Controller
public class HelloController {
    @GetMapping(value = "/hello", produces = "application/text;charset=utf-8")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
