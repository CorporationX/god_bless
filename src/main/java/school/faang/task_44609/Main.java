package school.faang.task_44609;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells spellsSystem = new HogwartsSpells();


        spellsSystem.addSpellEvent(1, "Spell", "Protects against attacks");
        spellsSystem.addSpellEvent(2, "Transfiguration", "Transforms an item");
        spellsSystem.addSpellEvent(3, "Spell", "Rewinds time");

        System.out.println("All spell events:");
        spellsSystem.printAllSpellEvents();
        System.out.println("----------------------");

        List<SpellEvent> charSpells = spellsSystem.getSpellEventsByType("Spell");
        System.out.println("All spells of the type: " + charSpells);
        System.out.println("----------------------");

        SpellEvent spell1 = spellsSystem.getSpellEventById(1);
        System.out.println(spell1);
        System.out.println("----------------------");

        spellsSystem.deleteSpellEvent(1);
        spellsSystem.printAllSpellEvents();

    }
}
