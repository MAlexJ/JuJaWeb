package ua.com.malex.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author malex
 */
public class CookiesFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(CookiesFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug(" >>>> CookiesFilter : init ");
        }

    }

    /**
     * https://github.com/carhartl/jquery-cookie
     * https://www.sitepoint.com/eat-those-cookies-with-jquery/
     *
     * <script src="resources/js/jquery.cookie.js"></script>
     * console.log($.cookie("SessionCreationTime"));
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug(" >>>> CookiesFilter : doFilter ");
        }
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        Long creationSessionTime = req.getSession().getCreationTime();
        Calendar calendar = Calendar.getInstance();
        Long difTime = calendar.getTimeInMillis() - creationSessionTime;

        // Cookie : SessionCreationTime
        Cookie cookie = new Cookie("SessionCreationTime", creationSessionTime.toString());
        res.addCookie(cookie);

        // Cookie : SessionTimer
        Cookie cookieTimer = new Cookie("SessionTimer", difTime.toString());
        res.addCookie(cookieTimer);

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        if (LOG.isDebugEnabled()) {
            LOG.debug(" >>>> CookiesFilter : destroy ");
        }

    }
}
