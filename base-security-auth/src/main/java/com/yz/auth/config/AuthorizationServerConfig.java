package com.yz.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

/**
 * @author : gaohan
 * @date : 2022/9/1 23:29
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // super.configure(endpoints);
        endpoints
                .authenticationManager(authenticationManager)   // 使用密码模式需要配置
                // .userDetailsService(userDetailsService)
                // .authorizationCodeServices(authorizationCodeServices)
                // .tokenServices(tokenService())
                .tokenStore(tokenStore) // 注册redis令牌仓库
                .allowedTokenEndpointRequestMethods(HttpMethod.POST, HttpMethod.GET);   // 支持GET,POST请求
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // super.configure(security);
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // super.configure(clients);

        // 设置客户端信息从数据库拿（oauth_client_details表）
        // clients.jdbc(dataSource);
        // 或
        clients.withClientDetails(jdbcClientDetailsService());
    }

    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }
}