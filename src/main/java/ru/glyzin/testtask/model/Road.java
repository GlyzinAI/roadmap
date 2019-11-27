package ru.glyzin.testtask.model;

import ru.glyzin.testtask.util.MathHelper;

public class Road extends AbstractBaseEntity {
    private City city1;
    private City city2;
    private double length;

    public Road(String name, City city1, City city2) {
        super(name);
        this.city1 = city1;
        this.city2 = city2;
        this.length = MathHelper.getLengthByCoords(city1.getX(), city1.getY(), city2.getX(), city2.getY());
    }

    public City getCity1() {
        return city1;
    }

    public void setCity1(City city1) {
        this.city1 = city1;
    }

    public City getCity2() {
        return city2;
    }

    public void setCity2(City city2) {
        this.city2 = city2;
    }


    @Override
    public String toString() {
        return "Road[" + "city1=" + city1 + ", city2=" + city2 + ", length=" + length + "] " + super.toString();
    }
}
