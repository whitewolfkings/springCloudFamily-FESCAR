package com.gssx.fescar.interceptor;

import com.alibaba.fescar.core.context.RootContext;
import com.gssx.fescar.config.FescarAutoConfiguration;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.Collections;

/**
 * 将上下文的XID放到请求头中
 */
public class FescarRestInterceptor  implements RequestInterceptor,ClientHttpRequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        if (!StringUtils.isEmpty(xid)) {
            requestTemplate.header(FescarAutoConfiguration.FESCAR_XID, xid);
        }
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        String xid = RootContext.getXID();
        if (!StringUtils.isEmpty(xid)) {
            HttpHeaders httpHeaders = httpRequest.getHeaders();
            httpHeaders.put(FescarAutoConfiguration.FESCAR_XID, Collections.singletonList(xid));
        }
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }

}
