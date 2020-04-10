package net.zqwzjs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @program: init1
 * @author: Mr.Zi
 * @create: 2020-04-08 13:18
 **/
@JsonIgnoreProperties(value = {"handler"})
@Table(name = "tb_role")
public class Role {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    @Column(name = "role_name")
    private String roleName;


    private List<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {

        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
