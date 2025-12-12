package es.ulpgc.hpi.p3.SmartRoute;


public class Traveler {

    private static int ID = 0;
    private final int id;
    private final String name;
    private final String country;

    public Traveler(String name, String country) {
        this.id = ++ID;
        this.name = name;
        this.country = country;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getCountry() { return country; }
}