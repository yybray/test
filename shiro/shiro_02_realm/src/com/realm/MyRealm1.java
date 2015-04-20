package com.realm;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm1 implements Realm {

    @Override
    public void checkPermission(PrincipalCollection arg0, String arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkPermission(PrincipalCollection arg0, Permission arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkPermissions(PrincipalCollection arg0, String... arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkPermissions(PrincipalCollection arg0,
            Collection<Permission> arg1) throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkRole(PrincipalCollection arg0, String arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkRoles(PrincipalCollection arg0, Collection<String> arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkRoles(PrincipalCollection arg0, String... arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean hasAllRoles(PrincipalCollection arg0, Collection<String> arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasRole(PrincipalCollection arg0, String arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean[] hasRoles(PrincipalCollection arg0, List<String> arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isPermitted(PrincipalCollection arg0, String arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPermitted(PrincipalCollection arg0, Permission arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection arg0, String... arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection arg0, List<Permission> arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection arg0, String... arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection arg0,
            Collection<Permission> arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token){
        //用户名
        String principal = token.getPrincipal().toString();
        //密码
        String credentials = new String((char[])token.getCredentials());
        if(!principal.equals("111")){
            //用户名错误
            throw new UnknownAccountException();
        }
        if(!credentials.equals("111")){
            //密码错误
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(principal, credentials, getName());
    }

    @Override
    public String getName() {
        return MyRealm1.class.getSimpleName();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //只支持 UsernamePasswordToken
        return token instanceof UsernamePasswordToken;
    }

}
