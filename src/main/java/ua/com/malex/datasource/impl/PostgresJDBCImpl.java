package ua.com.malex.datasource.impl;

import org.apache.log4j.Logger;
import ua.com.malex.constants.Constants;
import ua.com.malex.datasource.PostgresJDBC;
import ua.com.malex.model.DataSet;
import ua.com.malex.model.impl.DataSetImpl;

import java.sql.*;

import java.util.*;

public class PostgresJDBCImpl implements PostgresJDBC {
    private static final Logger LOG = Logger.getLogger(PostgresJDBCImpl.class);
    private Connection connection;
    private ResultSet resultSet;

    @Override
    public void connect(String database, String userName, String password) {
        try {
            Class.forName(Constants.DRIVER_POSTGRES);
            connection = DriverManager.getConnection(Constants.CONNECTING_URL + database, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error("PostgresJDBCImpl(String database, String userName, String password) -> " + e.getMessage());
        }

    }

    @Override
    public boolean close() {
        boolean flag = false;
        try {
            if (connection != null) {
                connection.close();
                flag = true;
            }

        } catch (SQLException e) {
            LOG.error("boolean close() -> " + e.getMessage());
        }
        return flag;
    }

    @Override
    public void update(String tableName, int id, DataSet newValue) {
        try {
            PreparedStatement update = connection.prepareStatement("UPDATE public." + tableName + " SET name = ?, password = ? WHERE id = ?");
            update.setString(1, newValue.get(Constants.NAME).toString());
            update.setString(2, newValue.get(Constants.PASSWORD).toString());
            update.setInt(3, id);
            update.executeUpdate();
            update.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> getTableColumns(String tableName) {
        PreparedStatement selectTable;
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            selectTable = connection.prepareStatement("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME =  '" + tableName + "'");
            resultSet = selectTable.executeQuery();
            while (resultSet.next()) {
                linkedList.add(resultSet.getString(1));
            }
            linkedList.add(linkedList.getFirst());
            linkedList.removeFirst();
            resultSet.close();
        } catch (SQLException e) {
            LOG.error("List<DataSet> getTableData(String tableName) -> " + e.getMessage());
        }
        return new LinkedHashSet<>(Collections.asLifoQueue(linkedList));
    }

    @Override
    public boolean isConnected() {
        return connection != null;
    }

    @Override
    public List<DataSet> getTableData(String tableName) {
        PreparedStatement selectTable;
        List<DataSet> list = new LinkedList<>();
        try {
            selectTable = connection.prepareStatement("SELECT * FROM public." + tableName);
            resultSet = selectTable.executeQuery();
            while (resultSet.next()) {
                DataSet dataSet = new DataSetImpl();
                dataSet.put(Constants.NAME, resultSet.getString(Constants.NAME));
                dataSet.put(Constants.PASSWORD, resultSet.getString(Constants.PASSWORD));
                dataSet.put(Constants.ID, resultSet.getInt(Constants.ID));
                list.add(dataSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOG.error("List<DataSet> getTableData(String tableName) -> " + e.getMessage());
        }
        return list;
    }

    @Override
    public Set<String> getTableNames() {
        PreparedStatement selectTableNames;
        Set<String> result = new TreeSet<>((o1, o2) -> {
            if (o1.charAt(0) < o2.charAt(0)) {
                return 1;
            }
            if (o1.charAt(0) > o2.charAt(0)) {
                return -1;
            }
            return 0;
        });
        try {
            selectTableNames = connection.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'");
            resultSet = selectTableNames.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString("table_name"));
            }
            resultSet.close();
        } catch (SQLException e) {
            LOG.error("Set<String> getTableNames() -> " + e.getMessage());
        }
        return result;
    }

    @Override
    public void create(String tableName, DataSet input) {
        PreparedStatement insertTable;
        try {
            if (input.getNames().contains(Constants.ID)) {
                insertTable = connection.prepareStatement("INSERT INTO public." + tableName + " (id, name, password) VALUES (? , ? , ?)");
                //  insertTable.setInt(1, (int) input.get(ID));
                insertTable.setInt(1, Integer.parseInt(input.get(Constants.ID).toString()));
                insertTable.setString(2, input.get(Constants.NAME).toString());
                insertTable.setString(3, input.get(Constants.PASSWORD).toString());
            } else {
                insertTable = connection.prepareStatement("INSERT INTO public." + tableName + " (name, password) VALUES (? , ?)");
                insertTable.setString(1, input.get(Constants.NAME).toString());
                insertTable.setString(2, input.get(Constants.PASSWORD).toString());
            }
            insertTable.executeUpdate();
            insertTable.close();
        } catch (SQLException e) {
            LOG.error("create(String tableName, DataSet input) -> " + e.getMessage());
        }
    }

    @Override
    public void clear(String tableName) {
        try {
            PreparedStatement clearTable = connection.prepareStatement("TRUNCATE TABLE public." + tableName + " RESTART IDENTITY CASCADE");
            clearTable.execute();
            clearTable.close();
        } catch (SQLException e) {
            LOG.error("clear(String tableName) -> " + e.getMessage());
        }
    }
}
