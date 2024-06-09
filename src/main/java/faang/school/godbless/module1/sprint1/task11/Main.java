package faang.school.godbless.module1.sprint1.task11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    public static Map<String, List<StreamEvent>> EVENTS_LIST = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Concert", "Something in the way"));
        addEvent(new StreamEvent(2, "Swim", "Go to the bathroom"));

        searchEventById(1);
        searchEventByName("Concert");
        deleteEventById(1);
        printAllEvents();
    }


    public static void addEvent(StreamEvent event) {
        EVENTS.put(event.getId(), event);
        EVENTS_LIST.put(event.getEvent(), new ArrayList<>() {{
            add(event);
        }});
    }

    public static void searchEventById(int id) {
        System.out.println(EVENTS.get(id));
    }

    public static void searchEventByName(String name) {
        List<StreamEvent> events = new ArrayList<>(EVENTS.values());
        for (StreamEvent event : events) {
            if (name.equals(event.getEvent())) {
                System.out.println(EVENTS_LIST.get(event.getEvent()));
            }
        }
    }

    public static void deleteEventById(int id) {
        EVENTS_LIST.remove(EVENTS.get(id).getEvent());
        EVENTS.remove(id);

    }

    public static void printAllEvents() {
        for(Map.Entry<Integer, StreamEvent> entry : EVENTS.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


}
