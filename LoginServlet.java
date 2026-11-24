package ex1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        // 1. Recuperer le username depuis le formulaire
        String username = request.getParameter("username");

        // 2. Creer ou recuperer la session HTTP
        HttpSession session = request.getSession();

        // 3. Stocker le username dans la session
        session.setAttribute("user", username);
        session.setAttribute("sessionUser", new SessionUser(username));
        session.removeAttribute("sessionUser");

        // 4. Afficher le message de confirmation
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<h2>Welcome " + username + "!</h2>");

        out.println("<p>You are successfully logged in.</p>");

        out.println("<a href='items.html'>Go to items page</a>");

        out.println("</body></html>");
    }
}
