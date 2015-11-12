package ua.com.malex.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConnectController extends AbstractController {
    private static final Logger LOG = Logger.getLogger(ConnectController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String db_name = req.getParameter("db_name");
        String user_name = req.getParameter("user_name");
        String password = req.getParameter("password");
        LOG.debug("db_name: " + db_name + "  user_name:" + user_name + "  password:" + password);
    }
}
