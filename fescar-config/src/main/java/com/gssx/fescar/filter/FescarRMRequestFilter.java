package com.gssx.fescar.filter;
import com.alibaba.fescar.core.context.RootContext;
import com.gssx.fescar.config.FescarAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求过滤器，获取XID并绑定到上下文中
 * @author  浅陌兮
 */
@Slf4j
public class FescarRMRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String currentXID = request.getHeader(FescarAutoConfiguration.FESCAR_XID);
        if (!StringUtils.isEmpty(currentXID)) {
            RootContext.bind(currentXID);
            log.info("current request bind XID:{}", currentXID);
        }
        try {
            filterChain.doFilter(request, response);
        } finally {
            String unbindXID = RootContext.unbind();
            if (unbindXID != null) {
                log.info("current request unbind XID:{}", unbindXID);
                if (!currentXID.equals(unbindXID)) {
                    log.info("XID is changed when request execute, check if it meets expectations please");
                }
            }
            if (currentXID != null) {
                log.info("XID is changed when request execute, check if it meets expectations please");
            }
        }
    }
    }
