package com.gaoxiong.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author gaoxiong
 * @ClassName TimeFilter
 * @Description TODO
 * @date 2018/10/25 23:33
 */
@Component
public class TimeFilter implements Filter {
    @Override
    public void init ( FilterConfig filterConfig ) throws ServletException {
        System.out.println("时间过滤器初始化");
    }

    @Override
    public void doFilter ( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
        System.out.println("时间过滤器启动");
        long currentTimeMillis = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("时间过滤器:耗时"+(System.currentTimeMillis()-currentTimeMillis));
        System.out.println("时间过滤器结束");
    }

    @Override
    public void destroy () {
        System.out.println("时间过滤器销毁");
    }
}
