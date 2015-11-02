package ua.com.malex.dao.impl;


import ua.com.malex.dao.CustomerDAO;
import ua.com.malex.dao.DAOFactory;

public class PostgresSqlDAOFactoryImpl implements DAOFactory {

    @Override
    public CustomerDAO getCustomerDAO() {
        return new PostgresSqlCustomerDAOImpl();
    }
}
