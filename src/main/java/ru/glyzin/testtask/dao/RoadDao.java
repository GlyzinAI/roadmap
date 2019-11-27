package ru.glyzin.testtask.dao;

import ru.glyzin.testtask.model.Road;

import java.util.List;

public interface RoadDao {

    Road add(Road road);

    void delete(String roadName);

    void deleteByCityName(String cityName);

    List<Road> getRoadsByName(String nameCity);
}
