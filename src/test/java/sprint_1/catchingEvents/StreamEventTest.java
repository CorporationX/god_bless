package sprint_1.catchingEvents;

import catchingEvents.StreamEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamEventTest {

    //для настройки начальных условий
    //для предварительной подготовки тестов перед выполнением каждого тестового метода
    //нужно для того чтобы тесты были изолированы, не зависели друг от друга, не зависели от класса
    //и инициализация обктов для каждого проходила отдельно

    Map<Integer, StreamEvent> streamEventMap;
    Map<String, List<StreamEvent>> specificStreamEventMap;

    @BeforeEach
    void setUp() {
        streamEventMap = new HashMap<>();
        specificStreamEventMap = new HashMap<>();
    }

    //позитивные
    //используют только корректные данные и возвращает нам корректный результат

    @Test
    void addEventTest() {
        StreamEvent event1 = new StreamEvent(1, "LOGIN", "User logged in");
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event1);

        assertEquals(event1, StreamEvent.findStreamEvent(1, streamEventMap));
    }

    @Test
    void removeEventTest() {
        StreamEvent event1 = new StreamEvent(13, "LOGIN", "User logged in");
        StreamEvent event2 = new StreamEvent(3, "LOGOUT", "User logged out");
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event1);
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event2);

        StreamEvent.removeStreamEvent(13, streamEventMap, specificStreamEventMap);

        assertNull(StreamEvent.findStreamEvent(13, streamEventMap));
        assertNotNull(StreamEvent.findStreamEvent(3, streamEventMap));
    }

    @Test
    void findEventMapTest() {
        StreamEvent event1 = new StreamEvent(13, "LOGIN", "User logged in");
        StreamEvent event2 = new StreamEvent(3, "LOGOUT", "User logged out");
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event1);
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event2);

        StreamEvent res1 = StreamEvent.findStreamEvent(13, streamEventMap);
        StreamEvent res2 = StreamEvent.findStreamEvent(3, streamEventMap);

        assertEquals(StreamEvent.findStreamEvent(13, streamEventMap), res1);
        assertEquals(StreamEvent.findStreamEvent(3, streamEventMap), res2);
    }

    @Test
    void findStreamEventList() {
        StreamEvent event1 = new StreamEvent(13, "LOGIN", "User logged in");
        StreamEvent event2 = new StreamEvent(3, "LOGOUT", "User logged out");
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event1);
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event2);

        List<StreamEvent> res1 = StreamEvent.findStreamEventList("LOGIN", specificStreamEventMap);

        assertEquals(specificStreamEventMap.get("LOGIN"), res1);
    }

    @Test
    void printAllEventTest() {
        StreamEvent event1 = new StreamEvent(13, "LOGIN", "User logged in");
        StreamEvent event2 = new StreamEvent(3, "LOGIN", "User logged in");
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event1);
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event2);

        assertEquals(2, StreamEvent.findStreamEventList("LOGIN", specificStreamEventMap).size());
    }

    //негативные
    //кейсы оперируют так корректными так и не корректными данными
    //цель: проверка исключительных ситуаций или обработка ошибок
    @Test
    void checkIdLessZero() {
        assertThrows(IllegalArgumentException.class, () -> new StreamEvent(-13, "LOGIN", "User logged in"));
    }

    @Test
    void checkTypeEventEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new StreamEvent(13, "", "User logged in"));
    }

    @Test
    void checkDataEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new StreamEvent(13, "LOGIN", ""));
    }
}