package ua.com.malex.controller;

import ua.com.malex.constants.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConnectController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String db_name = req.getParameter("db_name");
        String user_name = req.getParameter("user_name");
        String password = req.getParameter("password");
        try {
            db_manager.connect(db_name, user_name, password);
            req.getSession().setAttribute(Constants.DB_MANAGER, db_manager);
        } catch (Exception e) {
            //TODO Alert message
        }
        req.setAttribute("flag", "sqlcmd");
        req.setAttribute("isConnected", db_manager.isConnected());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
