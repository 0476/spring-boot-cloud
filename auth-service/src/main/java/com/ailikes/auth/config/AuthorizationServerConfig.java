package com.ailikes.auth.config;

import com.ailikes.auth.service.BaseUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private static final String ALL_RESOURCE_ID = "*";
    @Autowired
    private BaseUserDetailService baseUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManagerBean;

    @Autowired
    private DataSource dataSource;

    private static MessageDigestPasswordEncoder md5encoder = new MessageDigestPasswordEncoder("MD5");

//    @Bean
//    public JdbcTokenStore jdbcTokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
    @Bean
    public InMemoryTokenStore memoryTokenStore() {
        return new InMemoryTokenStore();
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)throws Exception {
        security.passwordEncoder(md5encoder)
                // 允许表单认证
                .allowFormAuthenticationForClients()
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)throws Exception {
        endpoints.authenticationManager(authenticationManagerBean)
                 .tokenStore(memoryTokenStore())
                 .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST,HttpMethod.OPTIONS)  //支持GET  POST  请求获取token
                 .userDetailsService(baseUserDetailService);;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource)
                .passwordEncoder(md5encoder)
//        clients.inMemory()
//                .withClient("auth-service")
//                .secret("password")
//                .resourceIds(ALL_RESOURCE_ID)
//                .accessTokenValiditySeconds(3600) // 1 hour
//                .refreshTokenValiditySeconds(2592000) // 30 days
//                .autoApprove(true)
//                .redirectUris("http://auth.ailikes.com:5000/uc/callback")
//                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token",  "implicit")
//                .scopes("server")
//                .and()
//
//                .withClient("sso-service")
//                .secret("password")
//                .resourceIds(ALL_RESOURCE_ID)
//                .accessTokenValiditySeconds(3600) // 1 hour
//                .refreshTokenValiditySeconds(2592000) // 30 days
//                .autoApprove(true)
//                .redirectUris("http://sso.ailikes.com:8085/sso/callback")
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .scopes("server")
//                .and()
//                .build();
        ;

    }
}