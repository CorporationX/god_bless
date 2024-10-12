package cathing.events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cathing.events.StreamEvent.addEvent;
import static cathing.events.StreamEvent.printEvent;
import static cathing.events.StreamEvent.removeEvent;
import static cathing.events.StreamEvent.searchById;
import static cathing.events.StreamEvent.searchEventList;


public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> map1 = new HashMap<>();
        Map<String, List<StreamEvent>> map2 = new HashMap<>();

        StreamEvent event1 = new StreamEvent(1, "Бег", "Пробежать 5 км");
        StreamEvent event2 = new StreamEvent(2, "Ходьба", "Пойти на работу пешком");
        StreamEvent event3 = new StreamEvent(3, "Сон", "Спать не менее 8-и часов");
        StreamEvent event4 = new StreamEvent(4, "Еда", "Есть здоровую пищу");
        StreamEvent event5 = new StreamEvent(5, "Чтение", "Читать каждый день");

        addEvent(map1, map2, event1);
        addEvent(map1, map2, event2);
        addEvent(map1, map2, event3);
        addEvent(map1, map2, event4);
        addEvent(map1, map2, event5);
        printEvent(map1);
        searchById(map1, 3);
        searchEventList(map2, "Бег");
        removeEvent(map1, map2, 3);
    }
}
