package school.faang.bjs2_68750;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Reparo", "Restore broken items");
        hogwartsSpells.addSpellEvent("Transfiguration", "Transform item");
        hogwartsSpells.addSpellEvent("Protection", "Protects from attacks");
        hogwartsSpells.addSpellEvent("Protection", "Protects from fire");

        System.out.println("All spells:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("Spell list by type \"Protection\":");
        List<SpellEvent> spellEventList = hogwartsSpells.getSpellEventsByType("Protection");
        spellEventList.forEach(System.out::println);

        System.out.println("Get spell by Id:");
        try {
            System.out.printf("Get spell by Id = %d: %s\n", 2, hogwartsSpells.getSpellEventById(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Get spell by Id = %d: %s\n", 6, hogwartsSpells.getSpellEventById(6));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Delete spell by Id:");
        try {
            hogwartsSpells.deleteSpellEvent(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            hogwartsSpells.deleteSpellEvent(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("All spells:");
        hogwartsSpells.printAllSpellEvents();
    }
}