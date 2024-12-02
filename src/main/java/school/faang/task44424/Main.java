package school.faang.task44424;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent(2, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(3, "Защита", "Создает защитный барьер");
        hogwartsSpells.addSpellEvent(2, "Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent(4, "Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent(2, "Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent(6, "Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent(5, "Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent(12, "Защита", null);

        System.out.println();
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.getSpellsById(5);

        List<SpellEvent> charmEvents = hogwartsSpells.getSpellEventsByType("Чар");
        System.out.println("События типа 'Чар': " + charmEvents + '\n');

        List<SpellEvent> defenseEvents = hogwartsSpells.getSpellEventsByType("Защита");
        System.out.println("События типа 'Защита': " + defenseEvents + '\n');

        List<SpellEvent> tranceEvents = hogwartsSpells.getSpellEventsByType("Трансфигурация");
        System.out.println("События типа 'Трансфигурация': " + tranceEvents + '\n');

        hogwartsSpells.deleteSpellEvent(2);

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(5);
    }
}
