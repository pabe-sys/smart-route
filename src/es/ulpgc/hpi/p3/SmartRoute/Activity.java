package es.ulpgc.hpi.p3.SmartRoute;

import java.time.LocalDateTime;

public class Activity {

    private static int ID = 0;
    private final int id;
    private final String title;
    private final LocalDateTime time;
    private final Place place;

    public Activity(String title, LocalDateTime time, Place place) {
        this.id = ++ID;
        this.title = title;
        this.time = time;
        this.place = place;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public LocalDateTime getTime() { return time; }

    public Place getPlace() { return place; }
}
