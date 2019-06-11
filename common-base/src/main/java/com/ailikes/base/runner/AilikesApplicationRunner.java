package com.ailikes.base.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述:
 *
 * @author 徐大伟
 * @version 1.0.0
 * @date 19-6-11 16:12
 */
@Component//被spring容器管理
@Order(1)//如果多个自定义ApplicationRunner，用来标明执行顺序
public class AilikesApplicationRunner implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(AilikesApplicationRunner.class);

    @Value("${server.domain}")
    private String serverDomain;

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.servlet.context-path}")
    private String serverContextPath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("==========项目启动，now=" + new Date());
        logger.info("==========访问地址[ "+serverDomain+":"+serverPort+serverContextPath+"  ]");
    }
}
