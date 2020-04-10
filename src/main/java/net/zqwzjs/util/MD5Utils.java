package net.zqwzjs.util;

import com.mysql.cj.exceptions.StatementIsClosedException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import javax.management.loading.PrivateMLet;

/**
 * @program: ssm-init
 * @author: Mr.Zi
 * @create: 2020-04-02 08:25
 **/
public class MD5Utils {
    //加密的盐值
    private static final String salt = "NODENVER";
    //算法名称
    private static final String algorith_name = "md5";
    private static final int hash_iterations = 1024;

    /**
     * 使用自定义的盐值NODENVER加密
     */
    public static String encrypt(String password) {
        return new SimpleHash(algorith_name, password, ByteSource.Util.bytes(salt), hash_iterations).toHex();
    }
    /**
     * 以 （username + orduster）作为盐值加密
     */
    public static String encrypt(String password,String salt) {
        return new SimpleHash(algorith_name, password, ByteSource.Util.bytes(salt), hash_iterations).toHex();
    }

    public static void main(String[] args) {
        //得到测试数据
        System.out.println(MD5Utils.encrypt("12345","user"));
    }
}
