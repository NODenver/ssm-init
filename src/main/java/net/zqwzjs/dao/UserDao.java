package net.zqwzjs.dao;

import net.zqwzjs.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from tb_user where username=#{username}")
    User findUserByUsername(String username);
}
