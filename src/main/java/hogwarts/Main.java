package hogwarts;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spellsSystem = new HogwartsSpells();

        spellsSystem.addSpellEvent("Charms", "Creates a magical shield");
        spellsSystem.addSpellEvent("Transfiguration", "Transforms an object");
        spellsSystem.addSpellEvent("Defense", "Protects from attacks");
        spellsSystem.printAllSpellEvents();

        SpellEvent event = spellsSystem.getSpellEventById(3);
        System.out.println(event != null ? event : "Event not found");

        List<SpellEvent> charmEvents = spellsSystem.getSpellEventsByType("Charms");
        charmEvents.forEach(System.out::println);

        spellsSystem.deleteSpellEvent(1);
        spellsSystem.printAllSpellEvents();
    }
}
