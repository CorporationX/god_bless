package school.faang.streamevent;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static Map<Integer, StreamEvent> eventMap = new HashMap<>();
    public static Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

    public static void addEvent(StreamEvent streamEvent) {
        eventMap.put(streamEvent.getId(), streamEvent);
        eventTypeMap.computeIfAbsent(streamEvent.getEventType(), event -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent receiveEventById(Integer id) {
        if (!eventMap.containsKey(id)) {
            log.error("Событие с id = {} не найдено", id);
            throw new IllegalArgumentException("Событие не найдено");
        } else {
            return eventMap.get(id);
        }
    }

    public static List<StreamEvent> receiveEventByType(String type) {
        if (!eventTypeMap.containsKey(type)) {
            log.error("События с типом: {} не найдены", type);
            throw new IllegalArgumentException("События не найдены");
        } else {
            return eventTypeMap.get(type);
        }
    }

    public static void deleteEventById(Integer id) {
        StreamEvent streamEvent = eventMap.get(id);
        eventTypeMap.get(streamEvent.getEventType()).remove(streamEvent);
        eventMap.remove(id);
    }

    public static void receiveAllEvents() {
        for(var eventEntry : eventMap.entrySet()) {
            System.out.printf("Событие %d: %s \n", eventEntry.getKey(), eventEntry.getValue());
        }
    }

    public static void main(String[] args) {
        addEvent(new StreamEvent("Логин пользователя", "Пользователь Alex15 вошел в систему"));
        addEvent(new StreamEvent("Редактирование профиля пользователя", "Пользователь Alex15 отредактировал профиль"));
        addEvent(new StreamEvent("Логин пользователя", "Пользователь Stray228 вошел в систему"));
        addEvent(new StreamEvent("Редактирование профиля пользователя", "Пользователь Stay228 отредактировал профиль"));
        addEvent(new StreamEvent("Публикация поста", "Пользователь Alex15 опубликовал пост"));

        receiveAllEvents();
        System.out.println("**********");
        addEvent(new StreamEvent("Публикация поста", "Пользователь Stray228 опубликовал пост"));
        System.out.println("**********");
        receiveAllEvents();
        System.out.println("**********");
        System.out.println(receiveEventByType("Публикация поста"));
        System.out.println("**********");
        System.out.println(receiveEventById(2));
        deleteEventById(2);
        System.out.println(receiveEventById(2));
        System.out.println("**********");
        System.out.println(receiveEventByType("Публикация поста"));
    }
}
