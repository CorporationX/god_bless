package faang.school.hashmap.catchingevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> groupStreamEventById = new HashMap<>();
    private static final Map<String, List<StreamEvent>> groupStreamEventByEvent = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent openAirJun = new StreamEvent(1, "Open Air", "20 jun - borovay");
        StreamEvent butkemp = new StreamEvent(2, "Butkemp", "14 august");
        StreamEvent openAirAugust = new StreamEvent(3, "Open Air", "8 august - borovay");

        addSteamEvent(openAirAugust);
        addSteamEvent(butkemp);
        addSteamEvent(openAirJun);

        System.out.println("Вывод по ID " + returnStreamEventById(1));

        List<StreamEvent> listEvent = returnListStreamEventByNameEvent("Open Air");

        for (StreamEvent streamEvent : listEvent) {
            System.out.println("Вывод до удаления" + streamEvent);
        }

        deleteStreamEventById(1);

        List<StreamEvent> listEvent1 = returnListStreamEventByNameEvent("Open Air");

        for (StreamEvent streamEvent : listEvent1) {
            System.out.println("Вывод после удаления " + streamEvent);
        }

        addSteamEvent(openAirJun);
        printAllStreamEvent();

    }

    private static void addSteamEvent(StreamEvent newEvent) {
        if (newEvent != null) {
            groupStreamEventById.put(newEvent.getId(), newEvent);
            groupStreamEventByEvent.computeIfAbsent(newEvent.getEventType(), k -> new ArrayList<>()).add(newEvent);
        }
    }

    private static StreamEvent returnStreamEventById(int id) {
        if (id != 0) {
            if (groupStreamEventById.containsKey(id)) {
                return groupStreamEventById.get(id);
            }
        }
        return null;
    }

    private static List<StreamEvent> returnListStreamEventByNameEvent(String nameEvent) {
        if (nameEvent != null && !(nameEvent.isBlank())) {
            if (groupStreamEventByEvent.containsKey(nameEvent)) {
                return groupStreamEventByEvent.get(nameEvent);
            }
        }
        return null;
    }

    private static void deleteStreamEventById(int id) {
        if (id != 0) {
            if (groupStreamEventById.containsKey(id)) {
                StreamEvent streamEvent = groupStreamEventById.get(id);
                groupStreamEventById.remove(id);
                if (groupStreamEventByEvent.containsKey(streamEvent.getEventType())) {
                    groupStreamEventByEvent.get(streamEvent.getEventType()).remove(streamEvent);
                }
            }
        }
    }

    private static void printAllStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> event : groupStreamEventById.entrySet()) {
            System.out.println(event);
        }
    }

}
