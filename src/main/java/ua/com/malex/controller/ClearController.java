package ua.com.malex.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClearController extends AbstractController {
    private static final Logger LOG = Logger.getLogger(ClearController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        db_manager = getDatabaseManager(req);
        db_manager.clear(req.getParameter("clear"));
    }
}
