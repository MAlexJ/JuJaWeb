package ua.com.malex.entity.impl;


import ua.com.malex.entity.TransferObject;

import java.util.*;

public class TransferObjectImpl implements TransferObject {
    private Map<String, Object> map = new LinkedHashMap<>();

    @Override
    public void put(String name, Object value) {
        this.map.put(name, value);
    }

    @Override
    public List<Object> getValues() {
        List list;
        Collection<Object> collection = map.values();
        if (collection instanceof List)
            list = (List) collection;
        else
            list = new ArrayList(collection);
        return list;
    }

    @Override
    public Set<String> getNames() {
        return map.keySet();
    }

    @Override
    public Object get(String name) {
        return this.map.get(name);
    }


    @Override
    public void updateFrom(TransferObject newValue) {
        this.map.clear();

        // TODO FIX
        this.map.put("name", "Pup");
        this.map.put("password", "pass2");
        this.map.put("id", 13);
    }
}
