package com.wyh.background_management.dao;

import com.wyh.background_management.pojo.SysPermission;
import com.wyh.background_management.pojo.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRolePermissionDao {
    List<SysPermission> findPermissionListByRoleId(@Param("roleId") Integer roleId);
}
