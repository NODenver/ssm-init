package net.zqwzjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: init1
 * @author: Mr.Zi
 * @create: 2020-04-08 10:17
 **/

@Controller
@RequestMapping("/toPage")
public class ToPageController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }
}
