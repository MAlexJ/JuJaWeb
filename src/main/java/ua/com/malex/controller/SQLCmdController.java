package ua.com.malex.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SQLCmdController extends AbstractController {
    private boolean connected = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        db_manager = getDatabaseManager(req);
        if (db_manager != null) {
            connected = db_manager.isConnected();
        }
        req.setAttribute("flag", "sqlcmd");
        req.setAttribute("isConnected", connected);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flag", "sqlcmd");
        db_manager = getDatabaseManager(req);
        req.setAttribute("isConnected", db_manager.isConnected());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
