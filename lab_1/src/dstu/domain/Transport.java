package dstu.domain;

public abstract class Transport implements ITransport{
    private String name;
    private int capacity;
    private double speed;

    public Transport() {
    }

    public Transport(String name, int capacity, double speed) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
    }

    public Transport(String[] line) {
        name = line[1];
        capacity = Integer.parseInt(line[2]);
        speed = Double.parseDouble(line[3]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Название: ");
        builder.append(name);
        builder.append(" | Вместительность: ");
        builder.append(capacity);
        builder.append(" пассажиров | Скорость: ");
        builder.append(speed);
        builder.append(" км/час: ");

        return builder.toString();
    }
}
