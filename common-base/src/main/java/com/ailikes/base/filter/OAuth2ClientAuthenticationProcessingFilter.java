//package com.ailikes.base.filter;
//
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.security.authentication.AuthenticationDetailsSource;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.oauth2.client.OAuth2RestOperations;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetailsSource;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//public class OAuth2ClientAuthenticationProcessingFilter extends org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter {
//
//    public OAuth2RestOperations restTemplate;
//
//    private ResourceServerTokenServices tokenServices;
//
//    private ApplicationEventPublisher eventPublisher;
//
//    private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new OAuth2AuthenticationDetailsSource();
//
//    private OAuth2AuthenticationManager oAuth2AuthenticationManager = new OAuth2AuthenticationManager();
//
//    public OAuth2ClientAuthenticationProcessingFilter(String defaultFilterProcessesUrl) {
//        super(defaultFilterProcessesUrl);
//        setAuthenticationManager(oAuth2AuthenticationManager);
//        setAuthenticationDetailsSource(authenticationDetailsSource);
//    }
//
//}