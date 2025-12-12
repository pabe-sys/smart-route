package es.ulpgc.hpi.p3.SmartRoute;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Traveler> travelers = new ArrayList<>();
    private static final List<Place> places = new ArrayList<>();
    private static final List<Route> routes = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = askCommand(scanner);

        while (!command.equals("exit")) {
            processCommand(command);
            command = askCommand(scanner);
        }

        System.out.println("Program closed.");
    }

    private static void processCommand(String command) {

        String[] parts = command.split(" ");

        if (parts[0].equals("add-traveler")) {
            Traveler t = new Traveler(parts[1], parts[2]);
            travelers.add(t);
            System.out.println("Traveler added: " + parts[1]);
        }

        else if (parts[0].equals("add-place")) {
            Place p = new Place(parts[1], parts[2]);
            places.add(p);
            System.out.println("Place added: " + parts[1]);
        }

        else if (parts[0].equals("add-route")) {
            int travelerId = Integer.parseInt(parts[2]);
            Traveler t = findTraveler(travelerId);

            if (t != null) {
                Route r = new Route(parts[1], t);
                routes.add(r);
                System.out.println("Route created: " + parts[1]);
            } else {
                System.out.println("Traveler not found.");
            }
        }

        else if (parts[0].equals("add-activity")) {
            int routeId = Integer.parseInt(parts[1]);
            int placeId = Integer.parseInt(parts[2]);

            Route r = findRoute(routeId);
            Place p = findPlace(placeId);

            if (r == null) {
                System.out.println("Route not found.");
                return;
            }
            if (p == null) {
                System.out.println("Place not found.");
                return;
            }

            String title = parts[3];
            LocalDateTime time = LocalDateTime.parse(parts[4]);

            Activity a = new Activity(title, time, p);
            r.addActivity(a);

            System.out.println("Activity added to route: " + r.getName());
        }

        else if (parts[0].equals("list-travelers")) {
            for (Traveler t : travelers) {
                System.out.println(t.getId() + " " + t.getName() + " " + t.getCountry());
            }
        }

        else if (parts[0].equals("list-routes")) {
            for (Route r : routes) {
                System.out.println(r.getId() + " " + r.getName() + " (Traveler: " + r.getTraveler().getName() + ")");
            }
        }

        else if (parts[0].equals("list-activities")) {
            int routeId = Integer.parseInt(parts[1]);
            Route r = findRoute(routeId);

            if (r == null) {
                System.out.println("Route not found.");
                return;
            }

            System.out.println("Activities for route " + r.getName() + ":");
            for (Activity a : r.getActivities()) {
                System.out.println(a.getId() + " " + a.getTitle() + " at " +
                        a.getPlace().getName() + " on " + a.getTime());
            }
        }

        else {
            System.out.println("Unknown command.");
        }
    }

    private static Traveler findTraveler(int id) {
        for (Traveler t : travelers) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    private static Place findPlace(int id) {
        for (Place p : places) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private static Route findRoute(int id) {
        for (Route r : routes) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    private static String askCommand(Scanner scanner) {
        System.out.println("Write a command");
        System.out.println(help());
        return scanner.nextLine().trim();
    }

    private static String help() {
        return """
                Commands:
                add-traveler <name> <country>
                add-place <name> <category>
                add-route <name> <travelerId>
                add-activity <routeId> <placeId> <title> <YYYY-MM-DDTHH:MM>
                list-travelers
                list-routes
                list-activities <routeId>
                exit
                """;
    }
}
