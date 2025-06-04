package school.faang.module1.bjs2_79704;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Чар", "Выпускает огонь");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Создаёт магический щит");
        hogwartsSpells.addSpellEvent("Чар", "Оглушает врага");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Превращает объект в животное");

        log.info("Все события:");
        hogwartsSpells.printAllSpellEvents();

        int testId = 1;
        SpellEvent eventById = hogwartsSpells.getSpellEventById(testId);
        log.info("Событие с ID = {}:", testId);
        log.info("{}", eventById);

        String testType = "Чар";
        log.info("События типа {}:", testType);
        List<SpellEvent> eventsByType = hogwartsSpells.getSpellEventsByType(testType);
        if (eventsByType != null) {
            eventsByType.forEach(System.out::println);
        } else {
            log.info("Нет событий данного типа");
        }

        int idToDelete = 2;
        SpellEvent deletedEvent = hogwartsSpells.deleteSpellEvent(idToDelete);
        log.info("Удаление по id {}: {}", idToDelete, deletedEvent != null ? "успешно" : "не удалось");
        log.info("Все события после удаления:");
        hogwartsSpells.printAllSpellEvents();
    }
}
