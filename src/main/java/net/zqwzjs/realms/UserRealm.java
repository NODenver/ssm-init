package net.zqwzjs.realms;

import net.zqwzjs.dao.UserDao;
import net.zqwzjs.entity.User;
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
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("doGetAuthorizationInfo...........");
        return null;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String userCode = userToken.getUsername();
        User user = userDao.findUserByUsername(userCode);

        System.out.println("userCode: "+userCode);
        System.out.println("user: "+user);
        if (user == null) {
            throw new UnknownAccountException("账户"+user.getUsername() + "不存在");
        }
        Object principal = user.getUsername();
        Object credentials = user.getPassword();
        System.out.println(credentials);
        String realmName = getName();
        String salt = user.getSalt();
        ByteSource byteSource = ByteSource.Util.bytes(salt);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, byteSource, realmName);
        return info;
    }

}
