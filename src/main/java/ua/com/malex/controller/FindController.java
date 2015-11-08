package ua.com.malex.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import ua.com.malex.model.DataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FindController extends AbstractController {
    private static final Logger LOG = Logger.getLogger(FindController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        List<DataSet> tableData = manager.getTableData(userName);
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(tableData, new TypeToken<List<DataSet>>() {
        }.getType());
        JsonArray jsonArray = element.getAsJsonArray();
        resp.setContentType("application/json");
        resp.getWriter().print(jsonArray);
//        String userName = req.getParameter("userName");
//
//
//        switch (userName) {
//            case "user":
//                resp.setContentType("application/json");
//                resp.getWriter().print("[{\"id\":1,\"name\":\"Alex\",\"password\":\"11111\"},{\"id\":2,\"name\":\"Anna\",\"password\":\"22222\"}]");
//
//                break;
//            case "test":
//                resp.setContentType("application/json");
//                resp.getWriter().print("[{\"id\":1,\"name\":\"Olga\",\"password\":\"3333\"},{\"id\":2,\"name\":\"Max\",\"password\":\"44444\"}]");
//
//                break;
//            default:
//                resp.setContentType("application/json");
//                resp.getWriter().print("[{\"flag\":1}]");
//                break;
//        }


    }
}
