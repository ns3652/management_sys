package com.wyh.background_management.dao;

import com.wyh.background_management.pojo.SysUserAuths;
import org.apache.ibatis.annotations.Param;

public interface SysUserAuthsDao {
    SysUserAuths findUserAuthsByIdentityTypeAndOpenIdCredential(@Param("identityType") int identityType, @Param("credential") String credential);
    void insertNewSysUserAuths(@Param("userId") Integer userId, @Param("identityType") int identityType, @Param("identityDisplay") String identityDisplay,
                               @Param("identifier") String identifier, @Param("credential") String credential, @Param("authImg") String authImg,
                               @Param("nickname") String nickname, @Param("gender") int gender);
}
