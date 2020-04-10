package net.zqwzjs.dao;

import net.zqwzjs.entity.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface RoleDao extends Mapper<Role> {

    @Select("select * from tb_role where id=#{0}")
    @Results(value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "role_name", property = "roleName"),
            @Result(property = "permissions", column = "id", many = @Many(select = "net.zqwzjs.dao.PermissionDao.findPermissionsByRid",fetchType = FetchType.LAZY))
    })
    Role findById(Integer id);

}
