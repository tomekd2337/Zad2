package pl.jaz.jazapp;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class SessionMap {

    private final Map<String, Session> sessions = new ConcurrentHashMap<>();

    public Session getSessions(String sessionId) {
        if (!sessions.containsKey(sessionId)){
            sessions.put(sessionId, new Session());
        }
        return sessions.get(sessionId);
    }

    public static class Session{

    }



}




