package school.faang.catchingEvents;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        SpellEvent spellEvent = null;
        List<SpellEvent> spellEventsList;

        hogwartsSpells.addSpellEvent("Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Чар", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.printAllSpellEvents();
        System.out.println("_____________________________________________________________________");

        try {
            spellEventsList = hogwartsSpells.getSpellEventsByType("Чар");
            spellEvent = hogwartsSpells.getSpellEventById(spellEventsList.get(0).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int spellEventId = spellEvent.getId();
        System.out.println("Delete this spell: " + spellEvent);
        hogwartsSpells.deleteSpellEvent(spellEventId);
        System.out.println("_____________________________________________________________________");
        System.out.println("After deleting:");
        hogwartsSpells.printAllSpellEvents();
    }
}