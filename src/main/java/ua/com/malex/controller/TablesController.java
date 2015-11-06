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

//        Gson gson = new Gson();
//        JsonElement element = gson.toJsonTree(tableNames, new TypeToken< Set<String>>() {}.getType());
//        JsonArray jsonArray = element.getAsJsonArray();
//        resp.setContentType("application/json");
       // resp.getWriter().print(jsonArray);
        resp.setContentType("application/json");
        resp.getWriter().print("[{\"name\":\"user\"},{\"name\":\"test\"}]");

    }
}
