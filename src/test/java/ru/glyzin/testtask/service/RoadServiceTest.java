package ru.glyzin.testtask.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.glyzin.testtask.dao.inmemory.InMemoryRoadDao;
import ru.glyzin.testtask.model.Road;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.glyzin.testtask.service.TestData.*;

public class RoadServiceTest {
    private RoadService roadService;

    @Before
    public void setUp() throws Exception {
        roadService = new RoadService(new InMemoryRoadDao());
        roadService.add(ROAD1);
        roadService.add(ROAD2);
        roadService.add(ROAD3);
    }

    @Test
    public void add() {
        roadService.add(ROAD4);
        List<Road> roadsByName = roadService.getRoadsByName("Moscow");
        Assert.assertEquals(roadsByName.size(), 3);
        Assert.assertEquals(roadsByName.iterator().next(), ROAD4);
    }

    @Test
    public void delete() {
        roadService.delete("Road1");
        List<Road> roadsByName = roadService.getRoadsByName("Moscow");
        assertEquals(roadsByName.size(), 1);
        assertEquals(roadsByName.iterator().next(), ROAD3);
    }

    @Test
    public void getRoadsByName() {
        List<Road> ekbRoads = roadService.getRoadsByName("Ekb");
        assertEquals(ekbRoads.get(0).getName(), "Road3");
        assertEquals(ekbRoads.get(1).getName(), "Road2");
    }
}