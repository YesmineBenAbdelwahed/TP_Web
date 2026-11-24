
package ex1;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
                         throws IOException, ServletException {

        System.out.println("LoggingFilter: Before chain.doFilter()");

        // Passer au filtre suivant
        chain.doFilter(request, response);

        System.out.println("LoggingFilter: After chain.doFilter()");
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}
