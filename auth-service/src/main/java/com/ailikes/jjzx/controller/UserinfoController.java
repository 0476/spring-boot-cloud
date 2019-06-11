package com.ailikes.jjzx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ailikes.jjzx.service.IUserinfoService;
import com.ailikes.jjzx.entity.Userinfo;
import java.util.*;


/**
 * <p>
 *  用户信息：前端控制器
 * </p>
 *
 * @author ailikes
 * @since 2019-06-01
 */
@RestController
@RequestMapping("/jjzx/userinfo")
public class UserinfoController {

    
    @Autowired
    private IUserinfoService iUserinfoService;


    /**
    * 新增
    */
    @PostMapping
    public boolean save(Userinfo userinfo){
        return iUserinfoService.save(userinfo);
    }

    /**
    * 通过id删除
    */
    @DeleteMapping
    public boolean delete(Userinfo userinfo){
        return iUserinfoService.removeById(userinfo.getId());
    }

    /**
    * 修改
    */
    @PutMapping
    public boolean updateById(Userinfo userinfo){
        return iUserinfoService.updateById(userinfo);
    }


    /**
    * 查询列表
    */
    @GetMapping("/list")
    public List<Userinfo> list(Userinfo userinfo ){
        QueryWrapper<Userinfo> wp = new QueryWrapper<>();
        //todo init wp
        return iUserinfoService.list(wp);
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public IPage<Userinfo> page(Page<Userinfo> page,Userinfo userinfo){
        QueryWrapper<Userinfo> wp = new QueryWrapper<>();
        //todo init wp
        return iUserinfoService.page(page,wp);
    }


}

