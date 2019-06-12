package com.gssx.fescar.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import com.gssx.fescar.filter.FescarRMRequestFilter;
import com.gssx.fescar.interceptor.FescarRestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


/**
 * fesar相关配置
 * @author 浅陌兮
 */
@Configuration
public class FescarAutoConfiguration {
    public static final String FESCAR_XID = "Fescar_XID";

    /**
     * 使用fescar代理数据源
     */
    @Bean
    public DataSource dataSource(Environment environment) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        try {
            dataSource.setDriver(DriverManager.getDriver(environment.getProperty("spring.datasource.url")));
        } catch (SQLException e) {
            throw new RuntimeException("can not recognize datasource driver");
        }
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return new DataSourceProxy(dataSource);
    }

    /**
     * 全局事务扫描，设置appName和groupName
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(Environment environment) {
        String applicationName = environment.getProperty("spring.application.name");
        String groupName = environment.getProperty("fescar.group.name");
        if (applicationName == null) {
            return new GlobalTransactionScanner(groupName == null ? "my_test_tx_group" : groupName);
        } else {
            return new GlobalTransactionScanner(applicationName, groupName == null ? "my_test_tx_group" : groupName);
        }
    }

    /**
     * 为请求添加拦截器
     */
    @ConditionalOnBean({RestTemplate.class})
    @Bean
    public Object addFescarInterceptor(Collection<RestTemplate> restTemplates) {
        restTemplates.stream().forEach(restTemplate -> {
            List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
            if (interceptors != null) {
                interceptors.add(fescarRestInterceptor());
            }
        });
        return new Object();
    }

    @Bean
    public FescarRMRequestFilter fescarRMRequestFilter() {
        return new FescarRMRequestFilter();
    }

    @Bean
    public FescarRestInterceptor fescarRestInterceptor() {
        return new FescarRestInterceptor();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
