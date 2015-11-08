package ua.com.malex.controller;

import com.google.gson.Gson;
import ua.com.malex.model.DatabaseManager;
import ua.com.malex.model.impl.DatabaseManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

    protected DatabaseManager manager;

    @Override
    public void init() throws ServletException {

        this.manager = new DatabaseManagerImpl();
        this.manager.connect("sqlcmd", "postgres", "postgres");
    }
    protected String valueToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

}
