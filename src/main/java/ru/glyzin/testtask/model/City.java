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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        City city = (City) o;

        if (Double.compare(city.x, x) != 0) return false;
        return Double.compare(city.y, y) == 0;
    }

    @Override
    public String toString() {
        return "City[" + "x=" + x + ", y=" + y + "] " + super.toString();
    }
}
