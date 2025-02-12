package bjs257119;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        generateTestData();
    }

    private static void generateTestData() {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        Map<Integer, SpellEvent> spellById = hogwartsSpells.getSpellById();
        Map<String, List<SpellEvent>> spellsByType = hogwartsSpells.getSpellsByType();

        System.out.printf("Size of spellById before addSpellEvent method: %d %n", spellById.size());
        System.out.printf("Size of spellsByType before addSpellEvent method: %d %n", spellsByType.size());
        hogwartsSpells.addSpellEvent("Cemetery Magic", "Find active tomb");
        hogwartsSpells.addSpellEvent("Cemetery Magic",
                "Establish contact with the Owner of the cemetery");
        hogwartsSpells.addSpellEvent("Cemetery Magic",
                "Summon the Spirit of the Dead for advice");
        hogwartsSpells.addSpellEvent("Klippotic Magic",
                "Initiation with Naahema");
        hogwartsSpells.addSpellEvent("Klippotic Magic",
                "Activate the Sigil of Bairiron");
        hogwartsSpells.addSpellEvent("Klippotic Magic",
                "Make a request to the Other Party");
        System.out.printf("Size of spellById after addSpellEvent method: %d %n", spellById.size());
        System.out.printf("Size of spellsByType after addSpellEvent method: %d %n", spellsByType.size());

        System.out.printf("Found SpellEvent by id: %s %n", hogwartsSpells.getSpellEventById(4));

        System.out.printf("Found SpellEvents by type: %s %n",
                hogwartsSpells.getSpellEventsByType("Klippotic Magic"));

        System.out.printf("Size of spellById before deleteSpellEvent method: %d %n", spellById.size());
        System.out.printf("Size of spellsByType before deleteSpellEvent method: %d %n", spellsByType.size());
        hogwartsSpells.deleteSpellEvent(1);
        System.out.printf("Size of spellById after deleteSpellEvent method: %d %n", spellById.size());
        System.out.printf("Size of spellsByType after deleteSpellEvent method: %d %n", spellsByType.size());

        spellsByType.forEach((key, value) -> System.out.printf("Number of spell events, where id = 1: %d %n",
                value.stream().filter(spellEvent -> spellEvent.getId() == 1).count()));

        hogwartsSpells.printAllSpellEvents();
    }
}
