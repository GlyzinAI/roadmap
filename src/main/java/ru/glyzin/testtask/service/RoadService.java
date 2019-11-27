package ru.glyzin.testtask.service;

import ru.glyzin.testtask.dao.RoadDao;
import ru.glyzin.testtask.model.Road;

import java.util.List;

public class RoadService {
    private RoadDao roadDao;

    public RoadService(RoadDao roadDao) {
        this.roadDao = roadDao;
    }

    public Road add(Road road) {
        return roadDao.add(road);
    }

    public void delete(String name) {
        roadDao.delete(name);
    }

    public List<Road> getRoadsByName(String nameCity) {
        return roadDao.getRoadsByName(nameCity);
    }
}
