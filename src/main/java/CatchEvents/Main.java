package CatchEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> idEventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> typeEventMap = new HashMap<>();

    public static void main(String[] args) {
        Main.addEvent(new StreamEvent(1, "Type1", "Data1"));
        Main.addEvent(new StreamEvent(2, "Type2", "Data2"));
        Main.addEvent(new StreamEvent(3, "Type3", "Data3"));
        Main.addEvent(new StreamEvent(4, "Type4", "Data4"));
        Main.addEvent(new StreamEvent(5, "Type5", "Data5"));


        Main.findAllEvents();

        System.out.println(findEventById(1));
        System.out.println(findEventByType("Type2"));

        Main.removeEventById(1);

        Main.findAllEvents();
    }

    public static void addEvent(StreamEvent event) {
        idEventMap.put(event.getId(), event);

        List<StreamEvent> tempEventList = typeEventMap.getOrDefault(event.getType(), new ArrayList<>());
        tempEventList.add(event);
        typeEventMap.put(event.getType(), tempEventList);
    }

    public static StreamEvent findEventById(int id) {
        return idEventMap.get(id);
    }

    public static List<StreamEvent> findEventByType(String type) {
        return typeEventMap.get(type);
    }

    public static void removeEventById(int id) {
        typeEventMap.remove(idEventMap.get(id).getType());
        idEventMap.remove(id);
    }

    public static void findAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : idEventMap.entrySet()) {
            System.out.println("ID " + entry.getValue().getId());
            System.out.println("Type " + entry.getValue().getType());
            System.out.println("Data " + entry.getValue().getData());
        }
    }
}
