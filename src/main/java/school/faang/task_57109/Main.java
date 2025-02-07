package school.faang.task_57109;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Чар", "Магические действия");

        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println();

        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType("Защита");
        for (SpellEvent spellEvent : spellEvents) {
            System.out.println(spellEvent);
        }

        hogwartsSpells.deleteSpellEvent(1);

        hogwartsSpells.printAllSpellEvents();

    }

}
