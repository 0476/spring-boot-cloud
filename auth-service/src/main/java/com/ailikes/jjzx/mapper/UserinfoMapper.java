package com.ailikes.jjzx.mapper;

import com.ailikes.jjzx.entity.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ailikes
 * @since 2019-06-01
 */
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    Userinfo getUserByUserName(@Param("userName") String userName);

}
