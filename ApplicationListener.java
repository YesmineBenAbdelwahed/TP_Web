package ex1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Application is starting...");

        ServletContext context = event.getServletContext();
        context.setAttribute("appName", "ING1 Web Application");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Application is stopping...");
    }
}
