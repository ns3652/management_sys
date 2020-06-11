package com.wyh.background_management.dao;

import com.wyh.background_management.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserDao {
    SysUser findById(@Param("id") Integer id);
    SysUser findByUsername(@Param("username") String username);
    List<SysUser> findAll();
    //void insertNewUser(@Param("username") String username, @Param("encodePassword") String encodePassword);
    void insertNewUser(SysUser sysUser);
}
