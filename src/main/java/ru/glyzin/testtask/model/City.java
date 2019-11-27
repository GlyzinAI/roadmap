package ru.glyzin.testtask.model;

public class City extends AbstractBaseEntity {
    private double x;
    private double y;

    public City(String name, double x, double y) {
        super(name);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "City[" + "x=" + x + ", y=" + y + "] " + super.toString();
    }
}
