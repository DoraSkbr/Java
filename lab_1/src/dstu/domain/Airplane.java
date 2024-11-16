package dstu.domain;

public class Airplane extends Transport{
    private String pilot;
    private String airport;
    private String departure;

    public Airplane() {
    }

    public Airplane(String[] line) {
        super(line[1], Integer.parseInt(line[2]), Double.parseDouble(line[3]));
        pilot = line[4];
        airport = line[5];
        departure = line[6];
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Самолет: ");
        builder.append(super.toString());
        builder.append(" | Пилот: ");
        builder.append(pilot);
        builder.append(" | Аэропорт: ");
        builder.append(airport);
        builder.append(" | Дата вылета: ");
        builder.append(departure);
        return builder.toString();
    }

}
