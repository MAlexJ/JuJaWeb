package ua.com.malex.controller;

import com.google.gson.JsonArray;
import ua.com.malex.entity.TransferObject;
import ua.com.malex.model.DatabaseManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        db_manager = (DatabaseManager) req.getSession().getAttribute("db_manager");
        String userName = req.getParameter("tableName");
        List<TransferObject> tableData = db_manager.getTableData(userName);
        JsonArray jsonArray = valueToJsonArray(tableData);
        resp.setContentType("application/json");
        resp.getWriter().print(jsonArray);
    }
}
