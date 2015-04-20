package com;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


public class LoginLogout {

    //private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);


    public static void main(String[] args) {
        
        //读取配置文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = factory.getInstance();
        
        SecurityUtils.setSecurityManager(securityManager);
        
        //获取当前数subject
        Subject currentUser = SecurityUtils.getSubject();
        
        // 判断是否登录
        if(!currentUser.isAuthenticated()){
            //UsernamePasswordToken token = new UsernamePasswordToken("username", "password");
            UsernamePasswordToken token = new UsernamePasswordToken("111", "111");
            try {
                //登录
                currentUser.login(token);
                System.out.println(currentUser.getPrincipal() + " ,已登录!");
            } catch (UnknownAccountException e){
                System.out.println("没有[" + token.getPrincipal() + "]这个用户。");
            } catch (IncorrectCredentialsException e){
                System.out.println("用户[" + token.getPrincipal() + "]密码错误。");
            } catch (AuthenticationException e) {
                //e.printStackTrace();
                System.out.println(e.getClass());
            }
        }
        //注销
        currentUser.logout();

        System.exit(0);
    }
}
