package ua.com.malex.dao.impl;

import ua.com.malex.dao.CustomerDAO;
import ua.com.malex.datasource.PostgresJDBC;
import ua.com.malex.datasource.impl.PostgresJDBCImpl;
import ua.com.malex.model.DataSet;

import java.util.List;
import java.util.Set;

public class PostgresSqlCustomerDAOImpl implements CustomerDAO {

    private PostgresJDBC postgresJDBC = new PostgresJDBCImpl();

    @Override
    public void connect(String database, String userName, String password) {
        this.postgresJDBC.connect(database, userName, password);
    }

    @Override
    public Set<String> getTableNames() {
        return this.postgresJDBC.getTableNames();
    }

    @Override
    public List<DataSet> getTableData(String tableName) {
        return this.postgresJDBC.getTableData(tableName);
    }

    @Override
    public boolean close() {
        return this.postgresJDBC.close();
    }

    @Override
    public void clear(String tableName) {
        this.postgresJDBC.clear(tableName);
    }


    @Override
    public void create(String tableName, DataSet input) {
        this.postgresJDBC.create(tableName, input);
    }

    @Override
    public void update(String tableName, int id, DataSet newValue) {
        this.postgresJDBC.update(tableName, id, newValue);
    }

    @Override
    public Set<String> getTableColumns(String tableName) {
        return this.postgresJDBC.getTableColumns(tableName);
    }

    @Override
    public boolean isConnected() {
        return postgresJDBC.isConnected();
    }
}
