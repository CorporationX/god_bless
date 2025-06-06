package school.faang.events;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чар", "Накладывает чары");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет 1");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет 2");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");

        var event = hogwartsSpells.getSpellEventById(0);
        System.out.println(event);

        var eventsByType = hogwartsSpells.getSpellEventsByType("Трансфигурация");
        System.out.println(eventsByType);

        hogwartsSpells.deleteSpellEvent(2);
        eventsByType = hogwartsSpells.getSpellEventsByType("Трансфигурация");
        System.out.println(eventsByType);

        hogwartsSpells.printAllSpellEvents();
    }
}
