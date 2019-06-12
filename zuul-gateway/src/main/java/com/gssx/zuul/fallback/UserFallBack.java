package com.gssx.zuul.fallback;
import com.alibaba.fastjson.JSONObject;
import com.gssx.zuul.filter.TokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述: 用户服务断路器
 *
 * @param:
 * @return:
 * @auther: mamengkai
 * @date: 2018-12-03 11:41
 */
@Component
public class UserFallBack implements FallbackProvider {
  private static final Logger log = LoggerFactory.getLogger(TokenFilter.class);
/**
 *
 * 功能描述: 异常的消息打印
 *
 * @param: [cause]
 * @return: org.springframework.http.client.ClientHttpResponse
 * @auther: mamengkai
 * @date: 2018-12-03 13:53
 */
  @Override
  public ClientHttpResponse fallbackResponse(Throwable cause) {
      if (cause != null && cause.getCause() != null) {
          String reason = cause.getCause().getMessage();
          log.info("Excption {}",reason);
      }
    return fallbackResponse();
  }
  /**
   * 功能描述: 可以配置指定的路由，值为serviceId，如sc-user-service
   *
   * @param: []
   * @return: java.lang.String
   * @auther: mamengkai
   * @date: 2018-12-03 11:44
   */
  @Override
  public String getRoute() {
    return "provider-user";
  }
/**
 *
 * 功能描述: 断路器返回信息
 *
 * @param: []
 * @return: org.springframework.http.client.ClientHttpResponse
 * @auther: mamengkai
 * @date: 2018-12-03 11:49
 */
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                JSONObject json =new JSONObject();
                json.put("code","50001");
                json.put("message","服务不可用");
                return new ByteArrayInputStream(json.toJSONString().getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
