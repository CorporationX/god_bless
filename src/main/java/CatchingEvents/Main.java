package CatchingEvents;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чары", "Защита от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Создает защитное поле");

        hogwartsSpells.printAllSpellEvents();

        String eventTypeToQuery = "Чары";
        List<SpellEvent> spellsOfType = hogwartsSpells.getSpellEventsByType(eventTypeToQuery);

        System.out.println("Заклинания типа '" + eventTypeToQuery + "':");
        for (SpellEvent spellEvent : spellsOfType) {
            System.out.println(spellEvent);
        }

        System.out.println("Получение заклинания по ID 1: " + hogwartsSpells.getSpellEventById(1));

        hogwartsSpells.deleteSpellEvent(1);
        System.out.println("После удаления заклинания с ID 1:");
        hogwartsSpells.printAllSpellEvents();
    }
}
