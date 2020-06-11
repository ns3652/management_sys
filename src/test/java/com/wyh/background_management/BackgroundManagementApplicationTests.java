package com.wyh.background_management;

import com.wyh.background_management.dao.SysRolePermissionDao;
import com.wyh.background_management.dao.SysUserDao;
import com.wyh.background_management.pojo.SysPermission;
import com.wyh.background_management.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackgroundManagementApplicationTests {
    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysRolePermissionDao sysRolePermissionDao;

    @Test
    public void contextLoads() {
    }

}
