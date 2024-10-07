package school.faang.catchesevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> listStreamEventMap = new HashMap<>();
    private static List<StreamEvent> streamEventsList = new ArrayList<>();
    public static void main(String[] args) {
        streamEventMap.put(12, new StreamEvent(14, "someEvent", "someData"));
        addNewStream(16, "newEvent16", "newData16");
        addNewStream(23, "newEvent23", "newData23");
        System.out.println(streamEventMap);
        System.out.println(listStreamEventMap);

        System.out.println(" ");
        System.out.println("Поиск по id");
        searchStream(16);

        System.out.println(" ");
        System.out.println("Поиск по событию newEvent");
        searchStreamEntry("newEvent16");

        System.out.println(" ");
        System.out.println("До удаления");
        System.out.println(streamEventMap);
        System.out.println(listStreamEventMap);

        System.out.println(" ");
        deleteStreamEvent(16);
        System.out.println("После удаление");
        System.out.println(streamEventMap);
        System.out.println(listStreamEventMap);

        System.out.println(" ");
        showAllEvents();

    }
    private static void addNewStream(Integer id, String eventType, String data) {
        streamEventsList.add(new StreamEvent(id, eventType, data));
        streamEventMap.put(id, new StreamEvent(id, eventType, data));
        listStreamEventMap.put(eventType, streamEventsList);
    }

    private static void searchStream(Integer id) {
        if (streamEventMap.get(id) == null) {
            System.out.println(id + " Такого ключа нет");
        } else {
            System.out.println(streamEventMap.get(id));
        }
    }

    private static void searchStreamEntry(String evenType) {
        if (listStreamEventMap.get(evenType) == null) {
            System.out.println(evenType + " Такого ключа нет");
        } else {
            System.out.println(listStreamEventMap.get(evenType));
        }
    }

    // в гите написал в комментарии почему использовал цикл, или я не правильно понял условия этого пункта?
    private static void deleteStreamEvent(Integer id) {
        String eventType = "";
        for (Map.Entry<Integer, StreamEvent> entry : streamEventMap.entrySet()) {
            if (id.equals(entry.getKey())) {
               eventType = entry.getValue().getEventType();
            }
        }
        streamEventMap.remove(id);
        listStreamEventMap.remove(eventType);
    }


    private static void showAllEvents() {
        System.out.println("событие потока streamEventMap");
        for (Map.Entry<Integer, StreamEvent> entry : streamEventMap.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("событие потока listStreamEventMap");
        for (Map.Entry<String, List<StreamEvent>> entry : listStreamEventMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
