package events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class Main {
    private static final Map<Integer, StreamEvent> LIST_EVENT = new HashMap<>();
    private static final Map<String, List<StreamEvent>> TYPE_EVENT = new HashMap<>();
    private static Integer idCount = 1;

    public static void main(String[] args) {

        addNewEvent("type 1", "ohh");
        addNewEvent("type 1", "woow");
        addNewEvent("type 2", "OMG");
        addNewEvent("type 2", "new OMG");

        System.out.println("All events: ");
        for (Map.Entry<Integer, StreamEvent> entry : LIST_EVENT.entrySet()) {
            System.out.println("Event: " + entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\n" + "Type events:");
        for (Map.Entry<String, List<StreamEvent>> entry : TYPE_EVENT.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        searchFromId(3);
        searchFromTypeEvent("type 1");
        removeEvent(1);

        System.out.println("\n" + "Type events after delete:");
        for (Map.Entry<String, List<StreamEvent>> entry : TYPE_EVENT.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void addNewEvent(String type, String data) {

        StreamEvent newStream = new StreamEvent(idCount, type, data);
        LIST_EVENT.put(idCount, newStream); //add or update (from id) new event in listEvent
        TYPE_EVENT.putIfAbsent(type, new ArrayList<>()); // check contain key, if not - create new ArrayList
        TYPE_EVENT.get(type).add(newStream);  // add new StreamEvent in ArrayList of typeEvent
        idCount++;
    }

    public static void searchFromId(int id) {
        System.out.println("\n" + "Search from ID: " + LIST_EVENT.get(id));
    }

    public static void searchFromTypeEvent(String type) {
        System.out.println("\n" + "Search from type Event: " + TYPE_EVENT.get(type));
    }

    public static void removeEvent(int id) {
        final int MIN_MAP_SIZE = 1;

        StreamEvent typeRemoveEvent = LIST_EVENT.get(id);
        if (typeRemoveEvent == null) {
            throw new RuntimeException("no this ID");
        }
        String typeRemoveEventType = typeRemoveEvent.getEventType();// key for Map typeEvent
        List<StreamEvent> streamEvents = TYPE_EVENT.get(typeRemoveEventType);  // Value for key of Map typeEvent

        if (streamEvents.size() == MIN_MAP_SIZE) {
            TYPE_EVENT.remove(typeRemoveEventType);  // if value (List) of Map typeEvent have 1 record - delete key from Map
        } else {
            Iterator<StreamEvent> stream = streamEvents.iterator();
            while (stream.hasNext()) {
                StreamEvent nextStream = stream.next();
                if (nextStream.getId() == id) {
                    stream.remove();
                }
            }
        }
        LIST_EVENT.remove(id);  // remove id from Map listEvent
    }
}