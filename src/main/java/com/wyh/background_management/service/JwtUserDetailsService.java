package com.wyh.background_management.service;

import com.wyh.background_management.dao.SysRolePermissionDao;
import com.wyh.background_management.dao.SysUserDao;
import com.wyh.background_management.dao.SysUserRoleDao;
import com.wyh.background_management.pojo.SysPermission;
import com.wyh.background_management.pojo.SysRole;
import com.wyh.background_management.pojo.SysUser;
import com.wyh.background_management.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.redis.timeout}")
    private String timeout;

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Resource
    private SysRolePermissionDao sysRolePermissionDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = null;
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (redisUtil.getListDataLength(username) > 0){         //读取redis缓存
            //第一元素为密码，后面元素为权限
            List<String> dataList = redisUtil.getAllListData(username);
            String password = dataList.remove(dataList.size() - 1);
            sysUser = new SysUser(username, password);
            for (String auth:dataList){
                authorities.add(new SimpleGrantedAuthority(auth));
            }
        }else {
            sysUser = sysUserDao.findByUsername(username);
            ArrayList<String> dataList = new ArrayList<>();
            System.out.println("=======================");
            if (StringUtils.isEmpty(sysUser)){
                throw new UsernameNotFoundException("SysUser not found with username: " + username);
            }else{
                dataList.add(sysUser.getPassword());
                List<SysRole> userRoles = sysUserRoleDao.findRoleListByUserId(sysUser.getUserId());

                for (SysRole role:userRoles){
                    List<SysPermission> permissions = sysRolePermissionDao.findPermissionListByRoleId(role.getRoleId());
                    permissions.stream().forEach(auth->{
                        dataList.add(auth.getPermissionName());
                        authorities.add(new SimpleGrantedAuthority(auth.getPermissionName()));
                    });
                }
            }
            redisUtil.setListData(username, dataList);
            redisUtil.setExpireTime(username, Integer.valueOf(timeout));     //设置redis缓存过期时间
        }
        return new User(username, sysUser!=null?sysUser.getPassword():null, authorities);
    }
}