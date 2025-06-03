package school.faang.bjs2_79663;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Чар", "Открывает замок");
        hogwartsSpells.addSpellEvent("Защита", "Защищает мысли от чтения");
        hogwartsSpells.addSpellEvent("Чар", "Поднимает предмет в воздух");

        log.info("Список событий:");
        hogwartsSpells.printAllSpellEvents();

        int eventId = 3;
        String eventType = "Чар";

        SpellEvent eventById = hogwartsSpells.getSpellEventById(eventId);
        log.info("SpellEvent by id:\n{}", eventById);

        List<SpellEvent> eventsByType = hogwartsSpells.getSpellEventsByType(eventType);
        log.info("SpellEvents by type:");
        eventsByType.forEach(System.out::println);

        SpellEvent spellEvent = hogwartsSpells.deleteSpellEvent(eventId);
        log.info("Событие удалено? - {}", spellEvent != null);

        log.info("Список событий:");
        hogwartsSpells.printAllSpellEvents();
    }
}
