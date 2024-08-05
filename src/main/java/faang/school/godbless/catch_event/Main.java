package faang.school.godbless.catch_event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> dataOfEvents = new HashMap<>();
    static Map<String, List<StreamEvent>> listEvents = new HashMap<>();

    public static void main(String[] args) {
        addNewEvent(1, "payment", "data1");
        addNewEvent(2, "payment", "data2");
        addNewEvent(3, "send", "data1");

        printAllInfo();

        System.out.println("\n");
        searchEvents(1);

        System.out.println("\n");
        searchEvents("payment");

        removeEvent(2);
        System.out.println("\n");

        printAllInfo();
    }

    public static void addNewEvent(int id, String eventType, String data) {
        StreamEvent event = new StreamEvent(id, eventType, data);
        dataOfEvents.put(event.getId(), event);
        if (listEvents.containsKey(eventType)) {
            listEvents.get(eventType).add(event);
        } else {
            List<StreamEvent> eventList = new ArrayList<>();
            eventList.add(event);
            listEvents.put(eventType, eventList);
        }
    }

    public static void searchEvents(int id) {
        if (dataOfEvents.containsKey(id)) {
            System.out.println("id = " + dataOfEvents.get(id).getId() + ", eventType = " + dataOfEvents.get(id).getEventType() + ", data = " + dataOfEvents.get(id).getData());
        }
    }

    public static void searchEvents(String eventType) {
        if (listEvents.containsKey(eventType)) {
            for (StreamEvent event : listEvents.get(eventType)) {
                System.out.println("id = " + event.getId() + ", eventType = " + event.getEventType() + ", data = " + event.getData());
            }
        }
    }

    public static void removeEvent(int id) {
        for (Map.Entry<String, List<StreamEvent>> entry : listEvents.entrySet()) {
            entry.getValue().remove(dataOfEvents.get(id));
        }
        dataOfEvents.remove(id);
    }

    public static void printAllInfo() {
        for (Map.Entry<String, List<StreamEvent>> entry : listEvents.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            for (StreamEvent event : entry.getValue()) {
                System.out.println("\tid = " + event.getId() + ", eventType = " + event.getEventType() + ", data = " + event.getData());
            }
        }
    }
}
