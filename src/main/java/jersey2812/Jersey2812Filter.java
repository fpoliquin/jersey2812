package jersey2812;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Jersey2812Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Thread " + Thread.currentThread().getName() + " is being acquired...");
        System.out.flush();

        chain.doFilter(request, response);

        System.out.println("Thread " + Thread.currentThread().getName() + " is being released.");
        System.out.flush();
    }

    @Override
    public void destroy() {
    }

}
