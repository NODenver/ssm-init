package net.zqwzjs.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: init1
 * @author: Mr.Zi
 * @create: 2020-04-08 10:13
 **/
@Controller
@RequestMapping("/shiro")
public class ShiroController {
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("rememberMe")boolean rememberMe) {
//        System.out.println(rememberMe);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
//            password = MD5Utils.encrypt(username, password);
//            System.out.println(password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            if (rememberMe) {
                token.setRememberMe(true);
            } else {
                token.setRememberMe(false);
            }
            try {
                subject.login(token);
            } catch (AuthenticationException e) {
                e.getMessage();
                e.printStackTrace();
                System.out.println("登陆失败");
                return "redirect:/login.jsp";
            }
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
