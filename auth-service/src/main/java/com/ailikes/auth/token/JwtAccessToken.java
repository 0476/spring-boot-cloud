package com.ailikes.auth.token;

import com.ailikes.auth.constant.Constant;
import com.ailikes.auth.entity.BaseUserDetail;
import com.ailikes.auth.util.JsonUtils;
import com.ailikes.jjzx.entity.Userinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.io.IOException;
import java.util.Map;


/**
 * 功能：自定义JwtAccessToken转换器
 * @author ailikes
 * @className JwtAccessToken
 * @date 2019-06-01
 */
public class JwtAccessToken extends JwtAccessTokenConverter {

    private static Logger logger = LoggerFactory.getLogger(JwtAccessToken.class);
    /**
     * 功能：生成token
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
        // 设置额外用户信息
        Userinfo userinfo = ((BaseUserDetail) authentication.getPrincipal()).getUserinfo();
        userinfo.setPassword(null);
        // 将用户信息添加到token额外信息中
        defaultOAuth2AccessToken.getAdditionalInformation().put(Constant.USER_INFO, userinfo);
        return super.enhance(defaultOAuth2AccessToken, authentication);
    }

    /**
     * 功能：解析token
     * @param value
     * @param map
     * @return
     */
    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
        OAuth2AccessToken oauth2AccessToken = super.extractAccessToken(value, map);
        try {
            convertData(oauth2AccessToken, oauth2AccessToken.getAdditionalInformation());
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return oauth2AccessToken;
    }

    private void convertData(OAuth2AccessToken accessToken,  Map<String, ?> map) throws IOException {
        accessToken.getAdditionalInformation().put(Constant.USER_INFO,convertUserData(map.get(Constant.USER_INFO)));

    }

    private Userinfo convertUserData(Object map) throws IOException {
        String json = JsonUtils.serialize(map);
        Userinfo user = JsonUtils.deserialize(json, Userinfo.class);
        return user;
    }
}