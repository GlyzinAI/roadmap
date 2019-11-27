package ru.glyzin.testtask.dao.inmemory;

import ru.glyzin.testtask.dao.RoadDao;
import ru.glyzin.testtask.model.Road;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import static ru.glyzin.testtask.util.ValidationUtil.checkNotFound;

public class InMemoryRoadDao extends InMemoryBaseDao implements RoadDao {
    private Map<String, InMemoryBaseDao<Road>> cityRoadsMap = new ConcurrentHashMap<>();

    @Override
    public Road add(Road road) {
        Objects.requireNonNull(road, "road must not be null");
        InMemoryBaseDao<Road> roads = cityRoadsMap.computeIfAbsent(road.getCity1().getName(), map -> new InMemoryBaseDao<>());
        roads.add(road);
        roads = cityRoadsMap.computeIfAbsent(road.getCity2().getName(), map -> new InMemoryBaseDao<>());
        return roads.add(road);
    }

    @Override
    public void delete(String entityName) {
        Objects.requireNonNull(entityName, "entityName must not be null");
        for (Map.Entry<String, InMemoryBaseDao<Road>> entry : cityRoadsMap.entrySet()) {
            entry.getValue().delete(entityName);
        }
    }

    @Override
    public void deleteByCityName(String cityName) {
        checkNotFound(cityRoadsMap.remove(cityName), cityName);
    }

    @Override
    public List<Road> getRoadsByName(String nameCity) {
        return checkNotFound(cityRoadsMap.get(nameCity).getList(), nameCity);
    }
}
