package ru.glyzin.testtask.dao;

import ru.glyzin.testtask.model.City;

public interface CityDao {
    City add(City city);

    void delete(String name);

    City getCityByName(String name);

    int countByCity();
}
