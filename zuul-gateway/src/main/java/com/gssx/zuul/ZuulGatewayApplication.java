package com.gssx.zuul;

import com.gssx.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
	/**Token 安全验证过滤器
	 *
	 * 功能描述:
	 *
	 * @param: []
	 * @return: com.fasterxml.jackson.core.filter.TokenFilter
	 * @auther: mamengkai
	 * @date: 2018-12-03 9:40
	 */
	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}
	}
