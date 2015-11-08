package ua.com.malex.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SQLCmdController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flag", "sqlcmd");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
