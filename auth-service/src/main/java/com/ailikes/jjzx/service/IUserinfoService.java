package com.ailikes.jjzx.service;

import com.ailikes.jjzx.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  用户信息服务类
 * </p>
 *
 * @author ailikes
 * @since 2019-06-01
 */
public interface IUserinfoService extends IService<Userinfo> {
    /**
     * 功能描述：根据用户名查询用户信息
     * @auth ailikes
     * @param userName 用户名
     * @return Userinfo 用户信息
     */
    public Userinfo getUserByUserName(String userName);
}
