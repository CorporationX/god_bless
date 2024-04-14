package faang.school.godbless.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> threadEvent = new HashMap<>();
    static Map<String, List<StreamEvent>> listOfEvents = new HashMap<>();

    private void addNewThreadEvent(int idEvent, String eventType, String dataEvent) {
        StreamEvent newEvent = new StreamEvent(idEvent, eventType, dataEvent);
        threadEvent.put(idEvent, newEvent);
        if (!listOfEvents.containsKey(eventType)) {
            listOfEvents.put(eventType, new ArrayList<>());
        }
        listOfEvents.get(eventType).add(newEvent);
    }

    private void searchThreadEventById(int idEvent) {
        if (threadEvent.containsKey(idEvent)) {

            System.out.println("Найденное событие: " + threadEvent.get(idEvent).getId() + ", " + threadEvent.get(idEvent).getEventType() + ", " + threadEvent.get(idEvent).getData());
        } else {
            System.out.println("Событие с таким id не найдено.");
        }
    }

    private void searchListOfEventsByType(String eventType) {
        if (listOfEvents.containsKey(eventType)) {
            System.out.println("Найден список событий: " + listOfEvents.get(eventType));
        } else {
            System.out.println("Список событий с таким типом не найден.");
        }
    }

    private void removeThreadEventById(int idEvent) {
        String eventType = threadEvent.get(idEvent).getEventType();
        if (threadEvent.containsKey(idEvent)) {
            threadEvent.remove(idEvent);
        } else {
            System.out.println("Такое событие не найден.");
        }
        if (listOfEvents.containsKey(eventType)) {
            List<StreamEvent> listOfEventsWithNeededEventType = listOfEvents.get(eventType);
            for (StreamEvent event : listOfEventsWithNeededEventType) {
                if (event.getEventType().equals(eventType) && (event.getId() == idEvent)) {
                    listOfEventsWithNeededEventType.remove(event);
                }
            }
        }
    }

    private void displayInfoAboutThreadEvent() {
        for (Map.Entry<Integer, StreamEvent> event : threadEvent.entrySet()) {
            System.out.println("ID события: " + event.getValue().getId()
                    + ", тип события: " + event.getValue().getEventType()
                    + ", данные события: " + event.getValue().getData());
        }
    }
}
