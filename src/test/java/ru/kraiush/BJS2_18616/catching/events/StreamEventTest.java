package ru.kraiush.BJS2_18616.catching.events;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.catching.events.Event;
import school.faang.catching.events.StreamEvent;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamEventTest {
    private StreamEvent streamEvent;

    @BeforeEach
    public void setUp() {
        streamEvent = new StreamEvent();
    }

    @Test
    @DisplayName("Добавление - позитивный кейс")
    public void add_withCorrectData() {
        //arrange
        Event event1 = new Event(1, "Работа", "Созвон насчет фичи с разработчиками Агента");

        //act
        streamEvent.add(event1);

        //assert
        assertEquals(event1, streamEvent.get(1));
    }

    @Test
    @DisplayName("Добавление - event null")
    public void add_withEventNull_throwsNullPointerException() {
        //act & assert
        assertThrows(IllegalArgumentException.class, () -> streamEvent.add(null));
    }

    @Test
    @DisplayName("Поиск - позитивный кейс")
    public void get_eventPresent_returnsEvent() {
        //arrange
        Event expected = new Event(1, "Работа", "Созвон насчет фичи с разработчиками Агента");
        streamEvent.add(expected);

        //act
        Event actual = streamEvent.get(1);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск - ключ отсутствует")
    public void get_eventAbsent_returnsNull() {
        //arrange
        Event expected = new Event(1, "Работа", "Созвон насчет фичи с разработчиками Агента");
        streamEvent.add(expected);

        //act
        Event actual = streamEvent.get(2);

        //assert
        assertNull(actual);
    }

    @Test
    @DisplayName("Поиск - позитивный кейс")
    public void get_typeEventPresent_returnsListEvent() {
        //arrange
        Event event1 = new Event(1, "Работа", "Созвон насчет фичи с разработчиками Агента");
        Event event2 = new Event(2, "Работа", "Ретро с командой");
        streamEvent.add(event1);
        streamEvent.add(event2);
        List<Event> expected = List.of(event1, event2);

        //act
        List<Event> actual = streamEvent.get("Работа");

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск - ключ отсутствует")
    public void get_typeEventAbsent_returnsNull() {
        //arrange
        Event event1 = new Event(1, "Работа", "Созвон насчет фичи с разработчиками Агента");
        Event event2 = new Event(2, "Работа", "Ретро с командой");
        streamEvent.add(event1);
        streamEvent.add(event2);

        //act
        List<Event> actual = streamEvent.get("Спорт");

        //assert
        assertNull(actual);
    }

    @Test
    @DisplayName("Поиск - ключ отсутствует")
    public void testRemove() {
        //arrange
        Event event1 = new Event(1, "Работа", "Созвон насчет фичи с разработчиками Агента");
        Event event2 = new Event(2, "Работа", "Ретро с командой");
        streamEvent.add(event1);
        streamEvent.add(event2);

        //act
        streamEvent.remove(2);

        //assert
        assertNull(streamEvent.get(2));
    }
}
