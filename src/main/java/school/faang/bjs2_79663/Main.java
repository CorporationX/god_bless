package school.faang.bjs2_79663;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Чар", "Открывает замок");
        hogwartsSpells.addSpellEvent("Защита", "Защищает мысли от чтения");
        hogwartsSpells.addSpellEvent("Чар", "Поднимает предмет в воздух");

        System.out.println("Список событий:");
        hogwartsSpells.printAllSpellEvents();

        int eventId = 3;
        String eventType = "Чар";

        SpellEvent eventById = hogwartsSpells.getSpellEventById(eventId);
        System.out.println("\nSpellEvent by id:\n" + eventById);

        List<SpellEvent> eventsByType = hogwartsSpells.getSpellEventsByType(eventType);
        System.out.println("\nSpellEvents by type:");
        eventsByType.forEach(System.out::println);

        hogwartsSpells.deleteSpellEvent(eventId);

        System.out.println("\nСписок событий:");
        hogwartsSpells.printAllSpellEvents();
    }
}
