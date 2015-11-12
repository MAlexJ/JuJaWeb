package ua.com.malex.model.impl;


import ua.com.malex.dao.CustomerDAO;
import ua.com.malex.dao.DAOFactory;
import ua.com.malex.entity.TransferObject;
import ua.com.malex.model.DatabaseManager;

import java.util.List;
import java.util.Set;

public class DatabaseManagerImpl implements DatabaseManager {
    private CustomerDAO dao;

    public DatabaseManagerImpl() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);
        if (daoFactory != null) {
            this.dao = daoFactory.getCustomerDAO();
        }
    }

    @Override
    public List<TransferObject> getTableData(String tableName) {
        return this.dao.getTableData(tableName);
    }

    @Override
    public int getSize(String tableName) {
        return 0;
    }

    @Override
    public Set<String> getTableNames() {
        return this.dao.getTableNames();
    }

    @Override
    public void connect(String database, String userName, String password) {
        this.dao.connect(database, userName, password);
    }

    @Override
    public void clear(String tableName) {
        this.dao.clear(tableName);
    }

    @Override
    public void create(String tableName, TransferObject input) {
        this.dao.create(tableName, input);
    }

    @Override
    public void update(String tableName, int id, TransferObject newValue) {
        this.dao.update(tableName, id, newValue);
    }

    @Override
    public Set<String> getTableColumns(String tableName) {
        return this.dao.getTableColumns(tableName);
    }

    @Override
    public boolean isConnected() {
        return this.dao.isConnected();
    }

    @Override
    public boolean close() {
        return this.dao.close();
    }
}
