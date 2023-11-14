package userRegistration.web.ui.filter;

import javax.servlet.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Incoming request: {}", request.getRemoteAddr());
        chain.doFilter(request, response);
    }
    public void destroy(){

    }
}
