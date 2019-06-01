package com.ailikes.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.ailikes.jjzx.entity.Userinfo;
import com.ailikes.jjzx.service.impl.UserinfoService;

/**
 * 功能描述: TODO
 *
 * @ClassName PasswordEncoderTest
 * @Description
 * @Author ailikes
 * @Date 2019-06-01 13:51
 * @Version 1.0.0
 */
// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class PasswordEncoderTest {

//    @Autowired
//    private UserinfoService userinfoService;d1b5adfe8a037c50a60b5c18a65c0f1e

    @Test
    public void test1() {
//        Userinfo user = userinfoService.getUserByUserName("yoyo");
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        Md5PasswordEncoder Md5PasswordEncoder = new Md5PasswordEncoder();
        MessageDigestPasswordEncoder messageDigestPasswordEncoder = new MessageDigestPasswordEncoder("MD5");
        // 加密
        String encodedPassword = messageDigestPasswordEncoder.encode("d1b5adfe8a037c50a60b5c18a65c0f1e");
        System.out.println(encodedPassword);
//        user.setPassword(encodedPassword);
    }

}
