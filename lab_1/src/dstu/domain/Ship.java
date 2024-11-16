package dstu.domain;

public class Ship extends Transport{
    private String captain;
    private String port;
    private int berth;

    public Ship() {
    }

    public Ship(String[] line) {
        super(line[1], Integer.parseInt(line[2]), Double.parseDouble(line[3]));
        captain = line[4];
        port = line[5];
        berth = Integer.parseInt(line[6]);
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getBerth() {
        return berth;
    }

    public void setBerth(int berth) {
        this.berth = berth;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Корабль: ");
        builder.append(super.toString());
        builder.append(" | Капитан: ");
        builder.append(captain);
        builder.append(" | Порт: ");
        builder.append(port);
        builder.append(" | Номер причала: ");
        builder.append(berth);
        return builder.toString();
    }
}
