package school.faang.eventhandler;

import java.util.List;

/*
 * Related to JIRA ticket: BJS2-68668
 */
public class Main {
    public static void main(String[] args) {
        HogwartsSpells spellsSystem = new HogwartsSpells();

        System.out.println("==== Добавление событий заклинаний ====");
        spellsSystem.addSpellEvent("Чар", "Защищает от атак");
        spellsSystem.addSpellEvent("Защита", "Отражает заклинания");
        spellsSystem.addSpellEvent("Чар", "Призывает невидимую силу");
        spellsSystem.addSpellEvent("Трансфигурация", "Преобразует предмет в другое существо");
        System.out.println();

        System.out.println("==== Вывод всех событий заклинаний ====");
        spellsSystem.printAllSpellEvents();
        System.out.println();

        System.out.println("==== Тест getSpellEventsByType для типа 'Чар' ====");
        List<SpellEvent> charEvents = spellsSystem.getSpellEventsByType("Чар");
        if (charEvents != null && !charEvents.isEmpty()) {
            for (SpellEvent spellEvent : charEvents) {
                System.out.printf("ID: %d, Тип: %s, Действие: %s\n", spellEvent.getId(), spellEvent.getEventType(),
                        spellEvent.getAction());
            }
        } else {
            System.out.println("События типа 'Чар' не найдены.");
        }
        System.out.println();

        System.out.println("==== Тест getSpellEventById ====");
        int testId = 1;
        SpellEvent eventById = spellsSystem.getSpellEventById(testId);
        if (eventById != null) {
            System.out.printf("Найдено событие по id %d:\n", testId);
            System.out.printf("ID: %d, Тип: %s, Действие: %s\n", eventById.getId(), eventById.getEventType(),
                    eventById.getAction());
        } else {
            System.out.printf("Событие по id %d не найдено.\n", testId);
        }
        System.out.println();

        System.out.println("==== Тест удаления события заклинания ====");
        // Удаляем событие с id = testId
        try {
            spellsSystem.deleteSpellEvent(testId);
            System.out.printf("Событие с id %d удалено.\n", testId);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.printf("PASSED: %s\n\n", e.getMessage());
        }

        System.out.println("==== Вывод всех событий заклинаний после удаления ====");
        spellsSystem.printAllSpellEvents();
    }
}
