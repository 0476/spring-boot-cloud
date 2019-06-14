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

    /**
     * 配置授权服务器的安全，意味着实际上是/oauth/token端点。
     * /oauth/authorize端点也应该是安全的
     * 默认的设置覆盖到了绝大多数需求，所以一般情况下你不需要做任何事情。
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)throws Exception {
//        super.configure(security);
        security.passwordEncoder(md5encoder)
                // 允许表单认证
                .allowFormAuthenticationForClients()
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()");
    }
    /**
     * 该方法是用来配置Authorization Server endpoints的一些非安全特性的，比如token存储、token自定义、授权类型等等的
     * 默认情况下，你不需要做任何事情，除非你需要密码授权，那么在这种情况下你需要提供一个AuthenticationManager
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)throws Exception {
//        super.configure(endpoints);
        endpoints.authenticationManager(authenticationManagerBean)
                 .tokenStore(memoryTokenStore())
                 .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST,HttpMethod.OPTIONS)  //支持GET  POST  请求获取token
                 .userDetailsService(baseUserDetailService);;
    }
    /**
     * 配置ClientDetailsService
     * 注意，除非你在下面的configure(AuthorizationServerEndpointsConfigurer)中指定了一个AuthenticationManager，否则密码授权方式不可用。
     * 至少配置一个client，否则服务器将不会启动。
     */
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