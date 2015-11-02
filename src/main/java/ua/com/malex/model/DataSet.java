package ua.com.malex.model;

import java.util.List;
import java.util.Set;

/**
 * Created by oleksandr.baglai on 02.10.2015.
 */
public interface DataSet {
    void put(String name, Object value);

    List getValues();

    Set<String> getNames();

    Object get(String name);

    void updateFrom(DataSet newValue);

}
