package events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class Main {
    private static final Map<Integer, StreamEvent> listEvent = new HashMap<>();
    private static final Map<String, List<StreamEvent>> typeEvent = new HashMap<>();

    public static void main(String[] args) {

        addNewEvent(01, "type 1", "ohh");
        addNewEvent(02, "type 1", "woow");
        addNewEvent(03, "type 2", "OMG");
        addNewEvent(03, "type 2", "new OMG");

        System.out.println("All events: ");
        for (Map.Entry entry : listEvent.entrySet()) {
            System.out.println("Event: " + entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\n" + "Type events:");
        for (Map.Entry entry : typeEvent.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        searchFromId(3);
        searchFromTypeEvent("type 1");
        removeEvent(1);

        System.out.println("\n" + "Type events after delete:");
        for (Map.Entry entry : typeEvent.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void addNewEvent(int id, String type, String data) {
        if (listEvent.containsKey(id)) {
            // remove from ArrayList of typeEvent old StreamEvent, this id will be update in listEvent
            typeEvent.get(type).remove(listEvent.get(id));
        }

        StreamEvent newStream = new StreamEvent(id, type, data);
        listEvent.put(id, newStream); //add or update (from id) new event in listEvent
        typeEvent.putIfAbsent(type, new ArrayList<>()); // check contain key, if not - create new ArrayList
        typeEvent.get(type).add(newStream);  // add new StreamEvent in ArrayList of typeEvent
    }

    public static void searchFromId(int id) {
        System.out.println("\n" + "Search from ID: " + listEvent.get(id));
    }

    public static void searchFromTypeEvent(String type) {
        System.out.println("\n" + "Search from type Event: " + typeEvent.get(type));
    }

    public static void removeEvent(int id) {
        final int MIN_MAP_SIZE = 1;

        StreamEvent typeRemoveEvent = listEvent.get(id);
        if (typeRemoveEvent == null) {
            throw new RuntimeException("no this ID");
        }
        String typeRemoveEventType = typeRemoveEvent.getEventType();// key for Map typeEvent
        List<StreamEvent> streamEvents = typeEvent.get(typeRemoveEventType);  // Value for key of Map typeEvent

        if (streamEvents.size() == MIN_MAP_SIZE) {
            typeEvent.remove(typeRemoveEventType);  // if value (List) of Map typeEvent have 1 record - delete key from Map
        } else {
            Iterator<StreamEvent> stream = streamEvents.iterator();
            while (stream.hasNext()) {
                StreamEvent nextStream = stream.next();
                if (nextStream.getId() == id) {
                    stream.remove();
                }
            }
        }
        listEvent.remove(id);  // remove id from Map listEvent
    }
}