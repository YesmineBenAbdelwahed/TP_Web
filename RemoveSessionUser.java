package ex1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RemoveSessionUser")
public class RemoveSessionUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (session != null && session.getAttribute("user") != null) {

            session.removeAttribute("user");

            out.println("<h2>SessionUser removed successfully!</h2>");

        } else {
            out.println("<h2>No SessionUser found!</h2>");
        }
    }
}
