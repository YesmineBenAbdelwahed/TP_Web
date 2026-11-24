
package ex1;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("SecurityFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
                         throws IOException, ServletException {

        System.out.println("SecurityFilter: Before chain.doFilter()");

        // 1. Convertir les objets en objets HTTP
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 2. Verifier si une session existe deja
        HttpSession session = req.getSession(false);

        // 3. Verifier si l'attribut user existe
        if (session != null && session.getAttribute("user") != null) {

            System.out.println("User is authenticated");

            // Autoriser la requete a continuer
            chain.doFilter(request, response);

            System.out.println("SecurityFilter: After chain.doFilter()");

        } else {

            System.out.println("User is not authenticated");

            // Rediriger vers login.html
            res.sendRedirect(req.getContextPath() + "/login.html");

        }
    }

    @Override
    public void destroy() {
        System.out.println("SecurityFilter destroyed");
    }
}
