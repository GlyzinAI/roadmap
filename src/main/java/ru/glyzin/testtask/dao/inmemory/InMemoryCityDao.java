package ru.glyzin.testtask.dao.inmemory;

import ru.glyzin.testtask.dao.CityDao;
import ru.glyzin.testtask.model.City;

import static ru.glyzin.testtask.util.ValidationUtil.checkNotFound;

public class InMemoryCityDao extends InMemoryBaseDao<City> implements CityDao {

    @Override
    public City getCityByName(String name) {
        return checkNotFound(map.get(name), name);
    }

    @Override
    public int countByCity() {
        return map.size();
    }
}
