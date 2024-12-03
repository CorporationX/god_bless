package school.faang.task_43513;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of HogwartsSpells
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        // Add some spell events
        hogwartsSpells.addSpellEvent(1, EventType.DEF, "Expelliarmus - Disarming spell");
        hogwartsSpells.addSpellEvent(2, EventType.CHAR, "Lumos - Creates light at wand tip");
        hogwartsSpells.addSpellEvent(3, EventType.TRANS, "Stupefy - Stuns the opponent");

        // Print all spell events
        System.out.println("All spell events:");
        hogwartsSpells.printAllSpellEvents();

        // Get and print a spell by its ID
        int spellIdToFind = 2;
        System.out.println("\nSpell with ID " + spellIdToFind + ":");
        System.out.println(hogwartsSpells.getSpellById(spellIdToFind));

        // Get and print spells by type
        EventType eventTypeToFind = EventType.DEF;
        System.out.println("\nSpells of type " + eventTypeToFind + ":");
        List<SpellEvent> combatSpells = hogwartsSpells.getSpellByType(eventTypeToFind);
        for (SpellEvent spellEvent : combatSpells) {
            System.out.println(spellEvent);
        }

        // Delete a spell and print all spells again
        int spellIdToDelete = 3;
        System.out.println("\nDeleting spell with ID " + spellIdToDelete + "...");
        hogwartsSpells.deleteSpellEvent(spellIdToDelete);

        System.out.println("\nAll spell events after deletion:");
        hogwartsSpells.printAllSpellEvents();
    }
}