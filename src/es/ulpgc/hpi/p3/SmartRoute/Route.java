package es.ulpgc.hpi.p3.SmartRoute;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private static int ID = 0;
    private final int id;
    private final String name;
    private final Traveler traveler;
    private final List<Activity> activities = new ArrayList<>();

    public Route(String name, Traveler traveler) {
        this.id = ++ID;
        this.name = name;
        this.traveler = traveler;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return new ArrayList<>(activities);
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public Traveler getTraveler() { return traveler; }
}
