package net.zqwzjs.service;

import net.zqwzjs.entity.User;

import java.util.List;


public interface UserService {

    User findUserByUsername(String username);

    List<User> selectAll();

    boolean update(User user);

    User selectById(Integer id);

    boolean deleteById(Integer id);
}
