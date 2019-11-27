package ru.glyzin.testtask.service;

import ru.glyzin.testtask.model.City;
import ru.glyzin.testtask.model.Road;

public class TestData {
    public static final City CITY1;
    public static final City CITY2;
    public static final City CITY3;
    public static final City CITY4;

    public static final Road ROAD1;
    public static final Road ROAD2;
    public static final Road ROAD3;
    public static final Road ROAD4;
    public static final Road ROAD5;
    public static final Road ROAD6;

    static {
        CITY1 = new City("Moscow", 175.6, 350.0);
        CITY2 = new City("Spb", 250.2, 600.4);
        CITY3 = new City("Ekb", 700.5, 800.0);
        CITY4 = new City("Murmansk", 100.5, 200.5);

        ROAD1 = new Road("Road1", CITY1, CITY2);
        ROAD2 = new Road("Road2", CITY2, CITY3);
        ROAD3 = new Road("Road3", CITY1, CITY3);
        ROAD4 = new Road("Road4", CITY1, CITY4);
        ROAD5 = new Road("Road5", CITY2, CITY4);
        ROAD6 = new Road("Road6", CITY3, CITY4);
    }
}
