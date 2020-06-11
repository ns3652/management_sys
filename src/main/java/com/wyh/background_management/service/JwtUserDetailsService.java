package com.wyh.background_management.service;

import com.wyh.background_management.dao.SysRolePermissionDao;
import com.wyh.background_management.dao.SysUserDao;
import com.wyh.background_management.dao.SysUserRoleDao;
import com.wyh.background_management.pojo.SysPermission;
import com.wyh.background_management.pojo.SysRole;
import com.wyh.background_management.pojo.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.security.Permission;
import java.util.*;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Resource
    private SysRolePermissionDao sysRolePermissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserDao.findByUsername(username);
        System.out.println("=======================");
        if (StringUtils.isEmpty(sysUser)){
            throw new UsernameNotFoundException("SysUser not found with username: " + username);
        }else{
            List<SysRole> userRoles = sysUserRoleDao.findRoleListByUserId(sysUser.getUserId());
            Set<GrantedAuthority> authorities = new HashSet<>();
            for (SysRole role:userRoles){
                List<SysPermission> permissions = sysRolePermissionDao.findPermissionListByRoleId(role.getRoleId());
                permissions.stream().forEach(auth->{
                    authorities.add(new SimpleGrantedAuthority(auth.getPermissionName()));
                });
            }
            return new User(username, sysUser.getPassword(), authorities);
        }
    }
}