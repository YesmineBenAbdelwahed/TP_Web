package ex1;

import jakarta.servlet.http.HttpSessionBindingListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class SessionUser implements HttpSessionBindingListener {

    private String username;

    public SessionUser(String username) {
        this.username = username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("SessionUser added to session: " + username);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("SessionUser removed from session: " + username);
    }
}
