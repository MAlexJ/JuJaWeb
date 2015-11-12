package ua.com.malex.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ua.com.malex.entity.TransferObject;
import ua.com.malex.model.DatabaseManager;
import ua.com.malex.model.impl.DatabaseManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Set;

public abstract class AbstractController extends HttpServlet {

    protected DatabaseManager manager;

    @Override
    public void init() throws ServletException {

        this.manager = new DatabaseManagerImpl();
        this.manager.connect("sqlcmd", "postgres", "postgres");
    }

    protected String valueToJson(Set<String> tableNames) {
        Gson gson = new Gson();
        return gson.toJson(tableNames);
    }

    protected JsonArray valueToJsonArray(List<TransferObject> tableData) {
        JsonArray jsonArray = new JsonArray();
        for (TransferObject dataSet : tableData) {
            JsonObject object = new JsonObject();
            object.addProperty("id", dataSet.get("id").toString());
            object.addProperty("name", dataSet.get("name").toString());
            object.addProperty("password", dataSet.get("password").toString());
            jsonArray.add(object);
        }
        return jsonArray;
    }
}
