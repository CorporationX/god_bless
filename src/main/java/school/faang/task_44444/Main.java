package school.faang.task_44444;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, EventType.DEF, "Expelliarmus - Disarming spell");
        hogwartsSpells.addSpellEvent(2, EventType.CHAR, "Lumos - Creates light at wand tip");
        hogwartsSpells.addSpellEvent(3, EventType.TRANS, "Stupefy - Stuns the opponent");

        System.out.println("All spell events:");
        hogwartsSpells.printAllSpellEvents();

        int spellIdToFind = 2;
        System.out.println("\nSpell with ID " + spellIdToFind + ":");
        SpellEvent spellFound = hogwartsSpells.getSpellById(spellIdToFind);

        if (spellFound != null) {
            System.out.println(hogwartsSpells.getSpellById(spellIdToFind));
        }

        EventType eventTypeToFind = EventType.DEF;
        System.out.println("\nSpells of type " + eventTypeToFind + ":");
        List<SpellEvent> combatSpells = hogwartsSpells.getSpellByType(eventTypeToFind);

        if (combatSpells != null) {
            for (SpellEvent spellEvent : combatSpells) {
                System.out.println(spellEvent);
            }
        }

        int spellIdToDelete = 3;
        System.out.println("\nDeleting spell with ID " + spellIdToDelete + "...");
        hogwartsSpells.deleteSpellEvent(spellIdToDelete);

        System.out.println("\nAll spell events after deletion:");
        hogwartsSpells.printAllSpellEvents();
    }
}