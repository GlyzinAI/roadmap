package ru.glyzin.testtask.service;

import org.junit.Before;
import org.junit.Test;
import ru.glyzin.testtask.dao.inmemory.InMemoryCityDao;
import ru.glyzin.testtask.dao.inmemory.InMemoryRoadDao;
import ru.glyzin.testtask.model.City;
import ru.glyzin.testtask.util.exception.NotFoundException;

import static org.junit.Assert.assertEquals;
import static ru.glyzin.testtask.service.TestData.*;

public class CityServiceTest {
    private CityService cityService;

    @Before
    public void setUp() throws Exception {
        cityService = new CityService(new InMemoryCityDao(), new InMemoryRoadDao());
        cityService.add(CITY1);
        cityService.add(CITY2);
        cityService.add(CITY3);
    }

    @Test
    public void add() {
        cityService.add(CITY4);
        City murmansk = cityService.getCityByName("Murmansk");
        City moscow = cityService.getCityByName("Moscow");
        assertEquals(murmansk, CITY4);
        assertEquals(moscow, CITY1);
        assertEquals(cityService.countByCity(), 4);
    }

    @Test
    public void delete() {
        cityService.delete("Moscow");
        assertEquals(cityService.countByCity(), 2);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        cityService.delete("Omsk");
    }

    @Test
    public void getCityByName() {
        assertEquals(cityService.getCityByName("Ekb"), CITY3);
    }

    @Test(expected = NotFoundException.class)
    public void getCityByNameNotFound() {
        cityService.getCityByName("Anapa");
    }
}