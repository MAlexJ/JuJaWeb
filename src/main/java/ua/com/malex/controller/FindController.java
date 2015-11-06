package ua.com.malex.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");


        switch (userName) {
            case "user":
                resp.setContentType("application/json");
                resp.getWriter().print("[{\"id\":1,\"name\":\"Alex\",\"password\":\"11111\"},{\"id\":2,\"name\":\"Anna\",\"password\":\"22222\"}]");

                break;
            case "test":
                resp.setContentType("application/json");
                resp.getWriter().print("[{\"id\":1,\"name\":\"Olga\",\"password\":\"3333\"},{\"id\":2,\"name\":\"Max\",\"password\":\"44444\"}]");

                break;
            default:
                resp.setContentType("application/json");
                resp.getWriter().print("[{\"flag\":1}]");
                break;
        }


    }
}
