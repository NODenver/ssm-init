package net.zqwzjs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.zqwzjs.dao.UserDao;

import net.zqwzjs.entity.User;

import net.zqwzjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: init1
 * @author: Mr.Zi
 * @create: 2020-04-08 15:29
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User findUserByUsername(String username) {
        User user = userDao.findUserByUserName(username);
        return user;
    }

    @Override
    public List<User> selectAll() {
        return userDao.UsersselectAll();
    }

    @Override
    public boolean update(User user) {
        int statu = userDao.updateByPrimaryKey(user);
        return statu==1?true:false;
    }

    @Override
    public User selectById(Integer id) {

        User user = userDao.findUserById(id);
        return user;
    }

    @Override
    public boolean deleteById(Integer id) {
        int status = userDao.deleteByPrimaryKey(id);
        return status == 1 ? true : false;
    }


}
