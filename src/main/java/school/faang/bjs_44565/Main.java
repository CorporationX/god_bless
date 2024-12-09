package school.faang.bjs_44565;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Чар", "Делает магию");
        hogwartsSpells.addSpellEvent(2, "Чар", "Делает еще одну магию");
        hogwartsSpells.addSpellEvent(3, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(4, "Защита", "Защищает от атак");

        log.info("Список событий после добавления");
        hogwartsSpells.printAllSpellEvents();

        printSpellById(1, hogwartsSpells);
        printSpellById(2, hogwartsSpells);
        try {
            printSpellById(5, hogwartsSpells);

        } catch (IllegalArgumentException e) {
            log.warn("Событие не найдено");
        }

        printSpellByEventType("Чар", hogwartsSpells);
        printSpellByEventType("Защита", hogwartsSpells);
        try {
            printSpellByEventType("Нападение", hogwartsSpells);
        } catch (IllegalArgumentException e) {
            log.warn("Событие не найдено");
        }

        hogwartsSpells.deleteSpellEvent(1);
        try {
            hogwartsSpells.deleteSpellEvent(7);
        } catch (IllegalArgumentException e) {
            log.warn("Событие не найдено");
        }

        log.info("Список событий после удаления");
        hogwartsSpells.printAllSpellEvents();
    }

    private static void printSpellById(int id, HogwartsSpells hogwartsSpells) {
        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(id);
        log.info(String.format("Поиск события с id %s: \t%s", id, spellEvent));
    }

    private static void printSpellByEventType(String eventType, HogwartsSpells hogwartsSpells) {
        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType(eventType);
        log.info(String.format("Поиск события с типом %s: \t%s", eventType, spellEvents));
    }
}
