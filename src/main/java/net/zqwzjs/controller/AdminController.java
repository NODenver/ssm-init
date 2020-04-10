package net.zqwzjs.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: init1
 * @author: Mr.Zi
 * @create: 2020-04-08 13:43
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping(value = "/test", produces="text/html;charset=UTF-8")
    @ResponseBody
    @RequiresRoles(value = {"admin"})
    public String test() {
        return "Admin 访问成功";
    }
}
