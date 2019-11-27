package ru.glyzin.testtask.service;

import ru.glyzin.testtask.dao.CityDao;
import ru.glyzin.testtask.dao.RoadDao;
import ru.glyzin.testtask.model.City;
import ru.glyzin.testtask.model.Road;

public class CityService {
    private CityDao cityDao;
    private RoadDao roadDao;

    public CityService(CityDao cityDao, RoadDao roadDao) {
        this.cityDao = cityDao;
        this.roadDao = roadDao;
    }

    public City add(City city) {
        roadDao.add(new Road("", city, city));
        return cityDao.add(city);
    }

    public void delete(String cityName) {
        cityDao.delete(cityName);
        roadDao.deleteByCityName(cityName);
    }

    public City getCityByName(String name) {
        return cityDao.getCityByName(name);
    }

    public int countByCity() {
        return cityDao.countByCity();
    }
}
