package school.faang;

import lombok.extern.java.Log;
import school.faang.bjs_44565.HogwartsSpells;
import school.faang.bjs_44565.SpellEvent;

import java.util.List;

@Log
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Чар", "Делает магию");
        hogwartsSpells.addSpellEvent(2, "Чар", "Делает еще одну магию");
        hogwartsSpells.addSpellEvent(3, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(4, "Защита", "Защищает от атак");

        log.info("Список событий после добавления");
        hogwartsSpells.printAllSpellEvents();

        try {
            printSpellById(1, hogwartsSpells);
            printSpellById(2, hogwartsSpells);
            printSpellById(5, hogwartsSpells);


        } catch (IllegalArgumentException e) {
            log.warning("Событие не найдено");
        }

        try {
            printSpellByEventType("Чар", hogwartsSpells);
            printSpellByEventType("Защита", hogwartsSpells);
            printSpellByEventType("Нападение", hogwartsSpells);
        } catch (IllegalArgumentException e) {
            log.warning("Событие не найдено");
        }

        try {
            hogwartsSpells.deleteSpellEvent(1);
            hogwartsSpells.deleteSpellEvent(7);
        } catch (IllegalArgumentException e) {
            log.warning("Событие не найдено");
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
