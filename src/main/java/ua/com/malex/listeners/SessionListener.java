package ua.com.malex.listeners;

import org.apache.log4j.Logger;
import ua.com.malex.constants.Constants;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private static final Logger LOG = Logger.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.getServletContext().setAttribute(Constants.CURRENT_SESSION_ACCOUNT, session);
        if (LOG.isDebugEnabled()) {
            LOG.debug("A new session with id='" + session.getId() + "' has been created");
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Session with id='" + session.getId() + "' has been destroyed");
        }
    }
}
