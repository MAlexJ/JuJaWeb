package ua.com.malex.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class TablesController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<String> tableNames = manager.getTableNames();
        String value = valueToJson(tableNames);
        resp.setContentType("application/json");
        resp.getWriter().print(value);
    }
}
