package com.ailikes.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ailikes.auth.entity.BaseUserDetail;
import com.ailikes.jjzx.entity.Userinfo;
import com.ailikes.jjzx.service.impl.UserinfoService;

@Service
public class BaseUserDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserinfoService userinfoService;

//    @Autowired
//    private BaseRoleService baseRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 调用FeignClient查询用户
        Userinfo userinfo = userinfoService.getUserByUserName(username);
        if(userinfo == null){
            logger.error("找不到该用户，用户名：" + username);
            throw new UsernameNotFoundException("找不到该用户，用户名：" + username);
        }
        // 调用FeignClient查询角色
//        ResponseData<List<BaseRole>> baseRoleListResponseData = baseRoleService.getRoleByUserId(baseUser.getId());
//        List<BaseRole> roles;
//        if(baseRoleListResponseData.getData() == null ||  !ResponseCode.SUCCESS.getCode().equals(baseRoleListResponseData.getCode())){
//            logger.error("查询角色失败！");
//            roles = new ArrayList<>();
//        }else {
//            roles = baseRoleListResponseData.getData();
//        }

        // 获取用户权限列表
        List<GrantedAuthority> authorities = new ArrayList();
//        roles.forEach(e -> {
//            // 存储用户、角色信息到GrantedAuthority，并放到GrantedAuthority列表
//            GrantedAuthority authority = new SimpleGrantedAuthority(e.getRoleCode());
//            authorities.add(authority);
//
//        });

        // 返回带有用户权限信息的User
        org.springframework.security.core.userdetails.User user =  new org.springframework.security.core.userdetails.User(userinfo.getUsername(),
                userinfo.getPassword(), isActive(userinfo.getStatus()), true, true, true, authorities);
        return new BaseUserDetail(userinfo, user);
    }

    private boolean isActive(String status){
        return "01".equals(status) ? true : false;
    }
}