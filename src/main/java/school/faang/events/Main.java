package school.faang.events;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Чар", "Накладывает чары");
        HogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет 1");
        HogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет 2");
        HogwartsSpells.addSpellEvent("Защита", "Защищает от атак");

        var event = HogwartsSpells.getSpellEventById(0);
        System.out.println(event);

        var eventsByType = HogwartsSpells.getSpellEventsByType("Трансфигурация");
        System.out.println(eventsByType);

        HogwartsSpells.deleteSpellEvent(2);
        eventsByType = HogwartsSpells.getSpellEventsByType("Трансфигурация");
        System.out.println(eventsByType);

        HogwartsSpells.printAllSpellEvents();
    }
}
