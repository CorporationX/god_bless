package school.faang.eventcatching;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SpellEvent spellEvent = null;
        List<SpellEvent> spellEvents;
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чар", "защита от атак");
        hogwartsSpells.addSpellEvent("Трансформация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Защищает доспехи");
        hogwartsSpells.printAllSpellEvents();
        System.out.println("_________________________________________");
        try {
            spellEvents = hogwartsSpells.getSpellEventsByType("Чар");
            spellEvent = hogwartsSpells.getSpellEventById(spellEvents.get(0).getId());
            System.out.println(spellEvent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int spellEventId = spellEvent.getId();
        System.out.println("delete this spell: " + spellEvent);
        hogwartsSpells.deleteSpellEvent(spellEventId);
        System.out.println("_________________________________________");
        System.out.println("After deleting");
        hogwartsSpells.printAllSpellEvents();
    }
}
