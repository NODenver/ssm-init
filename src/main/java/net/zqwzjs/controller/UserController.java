package net.zqwzjs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;
import net.zqwzjs.entity.User;
import net.zqwzjs.service.UserService;
import net.zqwzjs.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: init1
 * @author: Mr.Zi
 * @create: 2020-04-08 13:44
 **/

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/test", produces="text/html;charset=UTF-8")
    @ResponseBody
    @RequiresRoles(value = {"user","admin"},logical = Logical.OR)
    public String test() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        return "User 访问成功";
    }

    @PostMapping("/register")
    public String register(User user) {
        return null;
    }

    @GetMapping("/selectAll")
    @ResponseBody
    @RequiresPermissions(value = {"select"})
    public PageInfo<User> selectAll(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<User> users = userService.selectAll();
        PageInfo<User> info = new PageInfo<>(users);
        return info;
    }

    @PutMapping("/updatePassword")
    public String updatePassword(@RequestParam("password")String password,
                               @RequestParam("newPassword")String newPassword) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String oldPassword = MD5Utils.encrypt(password, user.getUsername());
        if (!user.getPassword().equals(oldPassword)) {
            System.out.println("输入的密码不正确");
        }
        user.setPassword(MD5Utils.encrypt(newPassword, user.getUsername()));
        boolean b = userService.update(user);
        if (b) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        return "redirect:/";
    }

    @GetMapping("/selectById/{id}")
    @ResponseBody
    public User selectById() {
        System.out.println("selectById");
        User user = userService.selectById(1);
        return user;
    }

    @PutMapping("/update")
    public String update(User user) {

        boolean update = userService.update(user);
        if (update) {
            return "redirect:/selectAll";
        }
        return "index";
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    @ApiOperation(value = "根据用户Id删除用户",notes = "根据用户Id删除用户",httpMethod = "Delete")
    public String deleteById(Integer id) {
        boolean b = userService.deleteById(id);
        return b ? "删除成功" : "删除失败";
    }
}
