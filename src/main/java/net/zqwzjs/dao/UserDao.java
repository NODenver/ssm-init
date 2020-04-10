package net.zqwzjs.dao;

import net.zqwzjs.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserDao extends Mapper<User> {
    @Select("select * from tb_user where username=#{0}")
    @Results(value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(property = "role", one = @One(select = "net.zqwzjs.dao.RoleDao.findById", fetchType = FetchType.LAZY),column = "rid")
    })
    User findUserByUserName(String username);

    @Select("select * from tb_user")
    @Results(value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "username", property = "username"),
            @Result(property = "role", one = @One(select = "net.zqwzjs.dao.RoleDao.findById", fetchType = FetchType.LAZY),column = "rid")
    })
    List<User> UsersselectAll();

    @Select("select * from tb_user where id=#{0}")
    @Results(value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(property = "role", one = @One(select = "net.zqwzjs.dao.RoleDao.findById", fetchType = FetchType.LAZY), column = "rid")
    })
    User findUserById(Integer id);
}
