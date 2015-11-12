package ua.com.malex.controller;

import org.apache.log4j.Logger;
import ua.com.malex.constants.Constants;
import ua.com.malex.entity.TransferObject;
import ua.com.malex.entity.impl.TransferObjectImpl;
import ua.com.malex.model.DatabaseManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


public class CreateController extends AbstractController {
    private static final Logger LOG = Logger.getLogger(CreateController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        db_manager = (DatabaseManager) req.getSession().getAttribute("db_manager");
        String table_table = req.getParameter("table_table");
        String[] table_names = req.getParameterValues("table_name");
        String[] table_passwords = req.getParameterValues("table_password");
        LOG.debug(table_table);
        LOG.debug(Arrays.toString(table_names));
        LOG.debug(Arrays.toString(table_passwords));
        //Временная верификация
        if (table_names.length == table_passwords.length && table_table.length() > 1) {
            TransferObject transferObject = new TransferObjectImpl();
            for (int i = 0; i < table_names.length; i++) {
                transferObject.put(Constants.NAME, table_names[i]);
                transferObject.put(Constants.PASSWORD, table_passwords[i]);
            }
            db_manager.create(table_table, transferObject);
        }
    }
}
