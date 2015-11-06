package ua.com.malex.controller;


import ua.com.malex.model.DatabaseManager;
import ua.com.malex.model.impl.DatabaseManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

    protected DatabaseManager manager;

    @Override
    public void init() throws ServletException {
        this.manager = new DatabaseManagerImpl();
        manager.connect("sqlcmd", "postgres", "postgres");
    }
}
