package net.zqwzjs.dao;

import net.zqwzjs.entity.Permission;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PermissionDao extends Mapper<Permission> {

    @Select("select * from tb_permission where id in (select pid from tb_role_permission where rid=#{0})")
    @Results(value = {
            @Result(property = "id",column = "id", id = true),
            @Result(property = "permissionName", column = "permission_name")
    })
    List<Permission> findPermissionsByRid(Integer id);
}
