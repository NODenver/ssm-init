package net.zqwzjs.realms;

import net.zqwzjs.entity.Permission;
import net.zqwzjs.entity.Role;
import net.zqwzjs.entity.User;
import net.zqwzjs.service.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @program: init1
 * @author: Mr.Zi
 * @create: 2020-04-08 10:06
 **/
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
//        System.out.println("======================================================");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        User user = (User) principal.getPrimaryPrincipal();
        Set<String> roleNames = new HashSet<>();
        Set<String> permissionNames = new HashSet<>();
        Role role = user.getRole();

        roleNames.add(role.getRoleName());
        List<Permission> permissions = role.getPermissions();
        for (Permission permission : permissions) {
            permissionNames.add(permission.getPermissionName());
        }

        System.out.println("具有的角色为："+roleNames);
        System.out.println("具有的权限有："+permissionNames);
        info.setRoles(roleNames);
        info.setStringPermissions(permissionNames);
        return info;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String userCode = userToken.getUsername();
        User user = userService.findUserByUsername(userCode);
        System.out.println("userCode: "+userCode);
        System.out.println("user: "+user);
        if (user == null) {
            throw new UnknownAccountException("账户"+user.getUsername() + "不存在");
        }
        Object principal = user;
        Object credentials = user.getPassword();
//        System.out.println(credentials);
        String realmName = getName();
        String salt = user.getUsername();
        ByteSource byteSource = ByteSource.Util.bytes(salt);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, byteSource, realmName);
        return info;
    }

}
