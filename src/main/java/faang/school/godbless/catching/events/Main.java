package faang.school.godbless.catching.events;

import java.util.*;

import static faang.school.godbless.catching.events.EventService.*;

public class Main {


    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "login", "User1 logged in"));
        addEvent(new StreamEvent(2, "logout", "User1 logged out"));
        addEvent(new StreamEvent(3, "login", "User2 logged in"));

        System.out.println("Find event by ID 2: " + findEventById(2));
        System.out.println("Find events by type 'login': " + findEventsByType("login"));

        removeEventById(2);

        printAllEvents();
    }
}
