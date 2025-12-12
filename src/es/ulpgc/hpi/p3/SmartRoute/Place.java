package es.ulpgc.hpi.p3.SmartRoute;

public class Place {

    private static int ID = 0;
    private final int id;
    private final String name;
    private final String category;

    public Place(String name, String category) {
        this.id = ++ID;
        this.name = name;
        this.category = category;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getCategory() { return category; }
}
