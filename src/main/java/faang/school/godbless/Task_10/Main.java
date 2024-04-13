package faang.school.godbless.Task_10;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Integer, StreamEvent> streamEvent = new HashMap<>();

        streamEvent.put(1, new StreamEvent(1, "Event1", "DataFromFirstEvent"));
        streamEvent.put(2, new StreamEvent(2, "Event1", "DataFromFirstEvent"));
        streamEvent.put(3, new StreamEvent(3, "Event1", "DataFromFirstEvent"));
        streamEvent.put(4, new StreamEvent(4, "Event2", "DataFromSecondEvent"));
        streamEvent.put(5, new StreamEvent(5, "Event2", "DataFromSecondEvent"));
        streamEvent.put(6, new StreamEvent(6, "Event2", "DataFromSecondEvent"));
        streamEvent.put(7, new StreamEvent(7, "Event3", "DataFromThirdEvent"));
        streamEvent.put(8, new StreamEvent(8, "Event3", "DataFromThirdEvent"));
        streamEvent.put(9, new StreamEvent(9, "Event3", "DataFromThirdEvent"));

        Map<String, List<StreamEvent>> listMapOfEvents = new HashMap<>();

        listMapOfEvents.put("Event1", new ArrayList<>(Arrays.asList(
                new StreamEvent(1, "Event1", "DataFromFirstEvent"),
                new StreamEvent(2, "Event1", "DataFromFirstEvent"),
                new StreamEvent(3, "Event1", "DataFromFirstEvent")
        )));

        listMapOfEvents.put("Event2", new ArrayList<>(Arrays.asList(
                new StreamEvent(4, "Event2", "DataFromSecondEvent"),
                new StreamEvent(5, "Event2", "DataFromSecondEvent"),
                new StreamEvent(6, "Event2", "DataFromSecondEvent")
        )));

        listMapOfEvents.put("Event3", new ArrayList<>(Arrays.asList(
                new StreamEvent(7, "Event3", "DataFromThirdEvent"),
                new StreamEvent(8, "Event3", "DataFromThirdEvent"),
                new StreamEvent(9, "Event3", "DataFromThirdEvent")
        )));

        update(streamEvent, listMapOfEvents, new StreamEvent(10, "Event4", "DataFromFourthEvent"));

        Optional<StreamEvent> eventUpdate = searchEvent(streamEvent, 11);
        if (eventUpdate.isPresent()) {
            System.out.println(eventUpdate.get());
        } else {
            System.out.println("There is no such element");
        }

        Optional<List<StreamEvent>> event = searchListOfEvents(listMapOfEvents, "Event0");
        if (event.isPresent()) {
            for (StreamEvent e : event.get()
            ) {
                System.out.println(event);
            }
        } else {
            System.out.println("There is no such events");
        }

        removeEventById(streamEvent, listMapOfEvents, 2);
        System.out.println(streamEvent);
        System.out.println(listMapOfEvents);

        allEvents(streamEvent);

    }

    static void update(Map<Integer, StreamEvent> streamEvent, Map<String, List<StreamEvent>> listMapOfEvents, StreamEvent event) {
        if (event != null) {
            streamEvent.putIfAbsent(event.getId(), event);
            System.out.println(streamEvent);
            System.out.println("---------------");
            if (listMapOfEvents.containsKey(event.getEventType())) {
                List<StreamEvent> events = listMapOfEvents.get(event);
                events.add(event);
                listMapOfEvents.put(event.getEventType(), events);
            } else {
                listMapOfEvents.put(event.getEventType(), new ArrayList<>(List.of(event)));
            }
            System.out.println(listMapOfEvents);
        }
        System.out.println("Argument is null");
    }

    static Optional<StreamEvent> searchEvent(Map<Integer, StreamEvent> streamEvent, int id) {
        StreamEvent event = streamEvent.get(id);
        if (event != null) {
            return Optional.of(event);
        } else return Optional.empty();
    }

    static Optional<List<StreamEvent>> searchListOfEvents(Map<String, List<StreamEvent>> listMapOfEvents, String typeEvent) {
        return Optional.ofNullable(listMapOfEvents.get(typeEvent));
    }

    static void removeEventById(Map<Integer, StreamEvent> streamEvent, Map<String, List<StreamEvent>> listMapOfEvents, int id) {
        streamEvent.remove(id);
        for (Map.Entry<String, List<StreamEvent>> entry : listMapOfEvents.entrySet()) {
            List<StreamEvent> value = entry.getValue();
            value.removeIf(e -> e.getId() == id);
        }
    }

    static void allEvents(Map<Integer, StreamEvent> streamEvent) {
        if (streamEvent != null) {
            for (Map.Entry<Integer, StreamEvent> entry : streamEvent.entrySet()) {
                StreamEvent streamEvent1 = entry.getValue();
                System.out.println(streamEvent1);
            }
        } else {
            System.out.println("Collection is null");
        }
    }
}
