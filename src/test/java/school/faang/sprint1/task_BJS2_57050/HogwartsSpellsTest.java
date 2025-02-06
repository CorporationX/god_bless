package school.faang.sprint1.task_BJS2_57050;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест класса HogwartsSpells")
class HogwartsSpellsTest {
    private static final int MIN_ID = 0;
    private HogwartsSpells hogwartsSpells;

    @BeforeEach
    public void setUp() {
        hogwartsSpells = new HogwartsSpells();
    }

    @Test
    @DisplayName("Добавление заклинания с валидными параметрами")
    public void addSpellEvent_RightParam() {
        assertDoesNotThrow(
                () -> hogwartsSpells.addSpellEvent("Защита", "Защищает от атак"));
    }

    @Test
    @DisplayName("Ошибка добавления заклинания с пустым типом заклинания")
    public void addSpellEvent_emptyEventType() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent("", "Защищает от атак"));
    }

    @Test
    @DisplayName("Ошибка добавления заклинания без типа заклинания")
    public void addSpellEvent_nullEventType() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent(null, "Защищает от атак"));
    }

    @Test
    @DisplayName("Ошибка добавления заклинания с пустым описанием заклинания")
    public void addSpellEvent_emptyActionDescription() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent("Защита", ""));
    }

    @Test
    @DisplayName("Ошибка добавления заклинания без описания заклинания")
    public void addSpellEvent_nullActionDescription() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent("Защита", null));
    }


    @Test
    @DisplayName("Ошибка получения заклинания с отрицательным id")
    public void getSpellEventById_wrongId() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.getSpellEventById(MIN_ID - 1));
    }

    @Test
    @DisplayName("Получение заклинания с минимальным id")
    public void getSpellEventById_boundOfId() {
        assertNull(hogwartsSpells.getSpellEventById(MIN_ID));
    }

    @Test
    @DisplayName("Получение заклинания по id")
    public void getSpellEventById_foundSpellEvent() {
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(MIN_ID);
        assertEquals("Защита", spellEvent.getEventType());
        assertEquals("Защищает от атак", spellEvent.getAction());
    }

    @Test
    @DisplayName("Ошибка получения списка заклинаний по пустому типу заклинания")
    public void getSpellEventsByType_emptyEventType() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.getSpellEventsByType(""));
    }

    @Test
    @DisplayName("Ошибка получения списка заклинаний без типа заклинания")
    public void getSpellEventsByType_nullEventType() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.getSpellEventsByType(null));
    }

    @Test
    @DisplayName("Получение списка заклинаний по типу заклинания")
    public void getSpellEventsByType_foundSpellEvents() {
        boolean isFound = false;
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType("Защита");

        for (SpellEvent spellEvent : spellEvents) {
            if (spellEvent.getAction().equals("Защищает от атак")) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound);
    }

    @Test
    @DisplayName("Ошибка удаления заклинания по отрицательному id")
    public void deleteSpellEvent_wrongId() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.deleteSpellEvent(MIN_ID - 1));
    }

    @Test
    @DisplayName("Удаление заклинания по id")
    public void deleteSpellEvent_delete() {
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        assertNotNull(hogwartsSpells.getSpellEventById(MIN_ID));
        hogwartsSpells.deleteSpellEvent(MIN_ID);
        assertNull(hogwartsSpells.getSpellEventById(MIN_ID));
    }

    @Test
    @DisplayName("Вывод всех заклинаний проверка на исключения")
    public void printAllSpellEvents_checkDoesNotThrow() {
        assertDoesNotThrow(() -> hogwartsSpells.printAllSpellEvents());
    }

}