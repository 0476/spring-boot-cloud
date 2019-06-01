package com.ailikes.jjzx.service.impl;

import com.ailikes.jjzx.entity.Userinfo;
import com.ailikes.jjzx.mapper.UserinfoMapper;
import com.ailikes.jjzx.service.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ailikes
 * @since 2019-06-01
 */
@Service
public class UserinfoService extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

    @Override
    public Userinfo getUserByUserName(String userName){
       return getBaseMapper().getUserByUserName(userName);
    }
}
