package lab.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lab.mvc.model.Person;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Récupérer les données du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        // 2. Créer un objet Person
        Person person = new Person(
            firstName, lastName, birthDay, sex
        );

        // 3. Ajouter l'objet à la requête
        request.setAttribute("person", person);

        // 4. Déterminer la page selon l'année de naissance
        String[] dateParts = birthDay.split("/");

        int year = Integer.parseInt(dateParts[2]);

        String page;

        if (year < 1990) {
            page = "/old.jsp";
        } else {
            page = "/young.jsp";
        }

        // 5. Transmettre la requête à la JSP
        jakarta.servlet.RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(page);

        dispatcher.include(request, response);
    }
}
