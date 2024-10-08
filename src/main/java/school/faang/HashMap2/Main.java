package school.faang.HashMap2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static school.faang.HashMap2.StreamEvent.addEvent;
import static school.faang.HashMap2.StreamEvent.printEventsInfo;
import static school.faang.HashMap2.StreamEvent.deleteEvent;
import static school.faang.HashMap2.StreamEvent.searchEvent;
import static school.faang.HashMap2.StreamEvent.searchEventList;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> idMap = new HashMap<>();
        Map<String, List<StreamEvent>> typeMap = new HashMap<>();
        addEvent(1, "enter", "21.00", idMap, typeMap);
        addEvent(2, "enter", "22.00", idMap, typeMap);
        addEvent(3, "exit", "3.00", idMap, typeMap);
        addEvent(4, "exit", "16.00", idMap, typeMap);
        addEvent(5, "subscribe", "19.00", idMap, typeMap);
        addEvent(6, "subscribe", "20.00", idMap, typeMap);

        printEventsInfo(typeMap);
        System.out.println(searchEvent(1, idMap));
        System.out.println(searchEvent(10, idMap));
        System.out.println(searchEventList("exit", typeMap));
        System.out.println(searchEventList("skipping", typeMap));
        System.out.println("Удалили событие c id №1");
        deleteEvent(1, idMap, typeMap);
        System.out.println(searchEvent(1, idMap));
        printEventsInfo(typeMap);

    }
}
