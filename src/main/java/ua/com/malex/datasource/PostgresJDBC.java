package ua.com.malex.datasource;


import ua.com.malex.model.DataSet;

import java.util.List;
import java.util.Set;

public interface PostgresJDBC {

    List<DataSet> getTableData(String tableName);

    boolean close();

    Set<String> getTableNames();

    void clear(String tableName);

    void create(String tableName, DataSet input);

    void update(String tableName, int id, DataSet newValue);

    Set<String> getTableColumns(String tableName);

    boolean isConnected();

    void connect(String database, String userName, String password);
}
