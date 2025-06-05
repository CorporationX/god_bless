package school.faang.bjs2_79687_spell_events;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Buff", "Strength bless");
        HogwartsSpells.addSpellEvent("Evocation", "Fireball");
        HogwartsSpells.addSpellEvent("Evocation", "Ice Storm");
        SpellEvent hex = HogwartsSpells.addSpellEvent("Hex", "Strength curse");
        HogwartsSpells.printAllSpellEvents();

        System.out.println("\n- Ensure spell deletion deletes from both registries. -");
        HogwartsSpells.deleteSpellEvent(hex.getId());
        HogwartsSpells.printAllSpellEvents();
        List<SpellEvent> spells = HogwartsSpells.getSpellEventsByType("hex");
        System.out.println("Found " + spells.size() + " hex type spells");

        System.out.println("\n- Print only evocation spells -");
        spells = HogwartsSpells.getSpellEventsByType("Evocation");
        spells.forEach(System.out::println);

        System.out.println("\n- Print only buff spells -");
        spells = HogwartsSpells.getSpellEventsByType("Buff");
        spells.forEach(System.out::println);

        System.out.println("\n- Find 'non-existent' type spells -");
        spells = HogwartsSpells.getSpellEventsByType("non-existent");
        System.out.println("Found " + spells.size() + " 'non-existent' type spells");

        System.out.println("\n- Print spell from registry with id = 1 -");
        System.out.println(HogwartsSpells.getSpellEventById(1));
    }
}
