package school.faang.catchevent;

import java.util.*;

public class Main {
    public static final String LOGIN = "LOGIN";
    public static final String LOGOUT = "LOGOUT";
    public static final String PAYMENT = "PAYMENT";

    public static void main(String[] args) {
        StreamEventService service = new StreamEventService();

        Map<Integer, StreamEvent> events = getEvents();
        Map<String, List<StreamEvent>> groupedEvents = getGroupedEvents();

        service.addStreamEvent(new StreamEvent( LOGIN, "User 8 logged in"), events);

        service.updateMapsByAddingEvent(events, groupedEvents);

        System.out.println("Founded event: " + service.findStreamEventById(1, events));

        System.out.println("Founded group of events: " + service.findListOfStreamEventsByEventType(LOGIN, groupedEvents));

        service.deleteEventsFromBothMaps(3, events, groupedEvents);

        for (StreamEvent streamEvent : service.showAllEvents(events)){
            System.out.println("Id of event: " + streamEvent.getId() + ", Type of event: " + streamEvent.getEventType() + ", Data of event: " + streamEvent.getData());
        }

    }

    public static Map<Integer, StreamEvent> getEvents(){
        Map<Integer, StreamEvent> events = new HashMap<>();

        events.put(1, new StreamEvent(1, LOGIN, "User 1 logged in"));
        events.put(2, new StreamEvent(2, LOGOUT, "User 2 logged out"));
        events.put(3, new StreamEvent(3, LOGIN, "User 3 logged in"));
        events.put(4, new StreamEvent(4, PAYMENT, "User 4 made a payment"));
        events.put(5, new StreamEvent(5, LOGIN, "User 5 logged in"));
        events.put(6, new StreamEvent(6, PAYMENT, "User 6 made a payment"));
        events.put(7, new StreamEvent(7, LOGOUT, "User 7 logged out"));

        return events;
    }

    public static Map<String, List<StreamEvent>> getGroupedEvents(){
        Map<String, List<StreamEvent>> groupedEvents = new HashMap<>();
        List<StreamEvent> eventsLogin = new ArrayList<>();
        eventsLogin.add(new StreamEvent(1, LOGIN, "User 1 logged in"));
        eventsLogin.add(new StreamEvent(3, LOGIN, "User 3 logged in"));
        eventsLogin.add(new StreamEvent(5, LOGIN, "User 5 logged in"));

        List<StreamEvent> eventsLogout = new ArrayList<>();
        eventsLogin.add(new StreamEvent(2, LOGOUT, "User 2 logged out"));
        eventsLogin.add(new StreamEvent(7, LOGOUT, "User 7 logged out"));

        List<StreamEvent> eventsPayment = new ArrayList<>();
        eventsLogin.add(new StreamEvent(4, PAYMENT, "User 4 made a payment"));
        eventsLogin.add(new StreamEvent(6, PAYMENT, "User 6 made a payment"));

        groupedEvents.put(LOGIN, eventsLogin);
        groupedEvents.put(LOGOUT, eventsLogout);
        groupedEvents.put(PAYMENT, eventsPayment);

        return groupedEvents;
    }
}
