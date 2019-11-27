package ru.glyzin.testtask.dao.inmemory;

import ru.glyzin.testtask.model.AbstractBaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBaseDao<T extends AbstractBaseEntity> {

    Map<String, T> map = new ConcurrentHashMap<>();

    public T add(T entry) {
        Objects.requireNonNull(entry, "entry must not be null");
        return map.put(entry.getName(), entry);
    }

    public void delete(String entityName) {
        Objects.requireNonNull(entityName, "entityName must not be null");
        map.remove(entityName);
    }

    public List<T> getList() {
        return new ArrayList<>(map.values());
    }
}
