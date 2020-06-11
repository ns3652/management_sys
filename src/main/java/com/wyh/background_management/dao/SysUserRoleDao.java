package com.wyh.background_management.dao;

import com.wyh.background_management.pojo.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleDao {
    List<SysRole> findRoleListByUserId(@Param("userId") Integer userId);
    void insertDefaultUserRole(@Param("userId") Integer userId);
}
