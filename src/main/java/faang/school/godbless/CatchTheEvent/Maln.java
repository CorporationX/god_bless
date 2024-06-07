package faang.school.godbless.CatchTheEvent;

import faang.school.godbless.StreamEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maln {
    private static Map<Integer, StreamEvenT> mapIdEvent = new HashMap<>();
    private static Map<String, List<StreamEvenT>> mapListEvent = new HashMap<>();

    public static void main(String[] args) {
        addEventStream(new StreamEvenT(1, "A", "aaa"));
        addEventStream(new StreamEvenT(2, "B", "bbb"));
        addEventStream(new StreamEvenT(3, "C", "ccc"));
        addEventStream(new StreamEvenT(4, "A", "aaa"));
        addEventStream(new StreamEvenT(5, "C", "ccc"));

        System.out.println(mapIdEvent);
        System.out.println("----------------------------");
        System.out.println(mapListEvent);

        addEventStream(new StreamEvenT(6, "C", "ccc"));

        System.out.println(mapIdEvent);
        System.out.println("----------------------------");
        System.out.println(mapListEvent);

        deleteEventStream(3);

        System.out.println(mapIdEvent);
        System.out.println("----------------------------");
        System.out.println(mapListEvent);

        System.out.println("==============================");
        System.out.println(searchEvent(4));
        System.out.println(searchStreamEvent("C"));
        ;
    }

    // добавления нового события потока
    static void addEventStream(StreamEvenT streamEvent) {
        if (!mapIdEvent.containsKey(streamEvent.getId())) {
            mapIdEvent.put(streamEvent.getId(), streamEvent);
            updateMapListEvent(streamEvent);
        } else {
            throw new IllegalArgumentException("ID такого элемента уже существует");
        }

    }

    // Обновление дополненной HashMap, где группируются объекты по типу события
    static void updateMapListEvent(StreamEvenT streamEvent) {
        if (mapListEvent.containsKey(streamEvent.getEventType())) {
            mapListEvent.get(streamEvent.getEventType()).add(streamEvent);
        } else {
            mapListEvent.computeIfAbsent(streamEvent.getEventType(), newListEvent -> new ArrayList<>()).add(streamEvent);
        }
    }

    // Поиск события потока по ID
    static StreamEvenT searchEvent(int id) {
        return mapIdEvent.get(id);
    }

    //поиск списка событий потока по типу события
    static List<StreamEvenT> searchStreamEvent(String typeEvent) {
        return mapListEvent.get(typeEvent);
    }

    //удаление события потока по его ID
    static void deleteEventStream(int id) {
        if (mapIdEvent.containsKey(id)) {
            updateDeleteMapListEvent(mapIdEvent.get(id));
            mapIdEvent.remove(id);
        } else {
            throw new IllegalArgumentException("Такого ID нет");
        }

    }

    // Обновление измененной HashMap
    static void updateDeleteMapListEvent(StreamEvenT streamEvent) {
        mapListEvent.get(streamEvent.getEventType()).remove(streamEvent);
    }
}
