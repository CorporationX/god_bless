package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(2, "Защита", "Защищает от атак");

        hogwartsSpells.printAllSpellEvents();

        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(1);
        System.out.println("SpellEvent by id: " + spellEvent.id + " " + spellEvent.eventType + " " + spellEvent.action);


        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType("Трансфигурация");
        System.out.println("SpellEvents by type: "
                + spellEvents.get(0).id + " "
                + spellEvents.get(0).eventType + " "
                + spellEvents.get(0).action);

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();

    }
}
