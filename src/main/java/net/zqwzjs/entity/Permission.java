package net.zqwzjs.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: init1
 * @author: Mr.Zi
 * @create: 2020-04-08 13:18
 **/
@JsonIgnoreProperties(value = {"handler"})
@Table(name = "tb_permission")
public class Permission {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    @Column(name = "permission_name")
    private String permissionName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
