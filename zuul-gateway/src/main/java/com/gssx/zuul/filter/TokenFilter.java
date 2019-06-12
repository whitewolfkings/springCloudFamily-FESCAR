package com.gssx.zuul.filter;

import com.gssx.zuul.utills.Constant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 功能描述: 网关过滤安全
 *
 * @param:
 * @return:
 * @auther: mamengkai
 * @date: 2018-12-02 16:43
 */
public class TokenFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(TokenFilter.class);
    /**
     *
     * 功能描述: 定义filter的类型，有pre、route、post、error四种
     *
     * @param: []
     * @return: java.lang.String
     * @auther: mamengkai
     * @date: 2018-12-02 16:51
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     *
     * 功能描述: 定义filter的顺序，数字越小表示顺序越高，越先执行
     *
     * @param: []
     * @return: int
     * @auther: mamengkai
     * @date: 2018-12-02 16:52
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     *
     * 功能描述: 表示是否需要执行该filter，true表示执行，false表示不执行
     *
     * @param: []
     * @return: boolean
     * @auther: mamengkai
     * @date: 2018-12-02 16:53
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest  request = requestContext.getRequest();
        HttpServletRequest requests = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("=========>>>>>>>",requests.getRequestURI());
        if("http://load/provider-user/login".equalsIgnoreCase(request.getRequestURL().toString())){
            return false;
        }else if("http://load/provider-user/login".equalsIgnoreCase(request.getRequestURL().toString())) {
            return false;
        }else {
            return true;
        }
    }

  /**
   *
   * 功能描述: 过滤器运行的方法
   *
   * @param: []
   * @return: java.lang.Object
   * @auther: mamengkai
   * @date: 2018-12-02 17:17
   */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response=ctx.getResponse();
        response.setCharacterEncoding("utf-8");//设置字符集
        response.setContentType("text/html;charset=utf-8");//设置相应格式
        log.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");// 获取请求的参数
        if (StringUtils.isNotBlank(token)) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(Constant.SUCCESS_CODE);
            ctx.set("isSuccess", true);
            return true;
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(Constant.TOKEN_IS_NULL_CODE);
            ctx.setResponseBody(Constant.TOKEN_IS_NULL_MESSAGE);
            ctx.set("isSuccess", false);
            return false;
        }
    }

}
