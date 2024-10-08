package school.faang.catchevent;

import java.util.*;

public class Main {
    public static final String LOGIN = "LOGIN";
    public static final String LOGOUT = "LOGOUT";
    public static final String PAYMENT = "PAYMENT";
    public static final String ID = UUID.randomUUID().toString();

    public static void main(String[] args) {
        StreamEventService service = new StreamEventService();

        Map<String, StreamEvent> events = getEvents();
        Map<String, List<StreamEvent>> groupedEvents = getGroupedEvents();

        service.addStreamEvent(new StreamEvent( LOGIN, "User 8 logged in"), events, groupedEvents);

        service.updateMapsByAddingEvent(events, groupedEvents);

        System.out.println("Founded event: " + service.findStreamEventById(ID, events));

        System.out.println("Founded group of events: " + service.findListOfStreamEventsByEventType(LOGIN, groupedEvents));

        service.deleteEventsFromBothMaps(ID, events, groupedEvents);

        for (StreamEvent streamEvent : service.showAllEvents(events)){
            System.out.println("Id of event: " + streamEvent.getId() + ", Type of event: " + streamEvent.getEventType() + ", Data of event: " + streamEvent.getData());
        }
    }

    public static Map<String, StreamEvent> getEvents(){
        Map<String, StreamEvent> events = new HashMap<>();

        events.put(ID, new StreamEvent(ID, LOGIN, "User 1 logged in"));
        events.put("testStringId2", new StreamEvent("testStringId1", LOGOUT, "User 2 logged out"));
        events.put("testStringId3", new StreamEvent("testStringId2", LOGIN, "User 3 logged in"));
        events.put("testStringId4", new StreamEvent("testStringId3", PAYMENT, "User 4 made a payment"));
        events.put("testStringId5", new StreamEvent("testStringId4", LOGIN, "User 5 logged in"));
        events.put("testStringId6", new StreamEvent("testStringId5", PAYMENT, "User 6 made a payment"));
        events.put("testStringId7", new StreamEvent("testStringId6", LOGOUT, "User 7 logged out"));

        return events;
    }

    public static Map<String, List<StreamEvent>> getGroupedEvents(){
        Map<String, List<StreamEvent>> groupedEvents = new HashMap<>();
        List<StreamEvent> eventsLogin = new ArrayList<>();
        eventsLogin.add(new StreamEvent("testStringId1", LOGIN, "User 1 logged in"));
        eventsLogin.add(new StreamEvent("testStringId3", LOGIN, "User 3 logged in"));
        eventsLogin.add(new StreamEvent("testStringId5", LOGIN, "User 5 logged in"));

        List<StreamEvent> eventsLogout = new ArrayList<>();
        eventsLogin.add(new StreamEvent("testStringId2", LOGOUT, "User 2 logged out"));
        eventsLogin.add(new StreamEvent("testStringId7", LOGOUT, "User 7 logged out"));

        List<StreamEvent> eventsPayment = new ArrayList<>();
        eventsLogin.add(new StreamEvent("testStringId4", PAYMENT, "User 4 made a payment"));
        eventsLogin.add(new StreamEvent("testStringId6", PAYMENT, "User 6 made a payment"));

        groupedEvents.put(LOGIN, eventsLogin);
        groupedEvents.put(LOGOUT, eventsLogout);
        groupedEvents.put(PAYMENT, eventsPayment);

        return groupedEvents;
    }
}
