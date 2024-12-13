package school.faang.sprint_1.task_44687;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(11, "Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent(12, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(11, "Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent(13, "Атака", "Наносит урон противнику");
        hogwartsSpells.addSpellEvent(11, "Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent(13, "Атака", "Наносит урон противнику");

        System.out.println(hogwartsSpells.getSpellEventById(12));

        List<SpellEvent> spellsByType = hogwartsSpells.getSpellEventsByType("Защита");
        System.out.println("\nЗаклинания типа 'Защита':");
        for (SpellEvent spellEvent : spellsByType) {
            System.out.println(spellEvent);
        }

        hogwartsSpells.deleteSpellEvent(13);

        System.out.println();
        hogwartsSpells.printAllSpellEvents();
    }
}
