package ua.com.malex.model;

import ua.com.malex.entity.TransferObject;

import java.util.List;
import java.util.Set;


public interface DatabaseManager {

    List<TransferObject> getTableData(String tableName);

    int getSize(String tableName);

    Set<String> getTableNames();

    void connect(String database, String userName, String password);

    void clear(String tableName);

    void create(String tableName, TransferObject input);

    void update(String tableName, int id, TransferObject newValue);

    Set<String> getTableColumns(String tableName);

    boolean isConnected();
    boolean close();

}
