package school.faang.bjs2_79687_spell_events;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Buff", "Strength bless");
        HogwartsSpells.addSpellEvent("Evocation", "Fireball");
        HogwartsSpells.addSpellEvent("Evocation", "Ice Storm");
        SpellEvent hex = HogwartsSpells.addSpellEvent("Hex", "Strength curse");
        HogwartsSpells.printAllSpellEvents();

        log.info("Ensure spell deletion deletes from both registries.");
        HogwartsSpells.deleteSpellEvent(hex.getId());
        HogwartsSpells.printAllSpellEvents();
        List<SpellEvent> spells = HogwartsSpells.getSpellEventsByType("hex");
        log.info("Found " + spells.size() + " hex type spells");

        log.info("Print only evocation spells");
        spells = HogwartsSpells.getSpellEventsByType("Evocation");
        spells.forEach(System.out::println);

        log.info("Print only buff spells");
        spells = HogwartsSpells.getSpellEventsByType("Buff");
        spells.forEach(System.out::println);

        log.info("Find 'non-existent' type spells");
        spells = HogwartsSpells.getSpellEventsByType("non-existent");
        log.info("Found " + spells.size() + " 'non-existent' type spells");

        log.info("Print spell from registry with id = 1");
        log.info("Found {}", HogwartsSpells.getSpellEventById(1));
    }
}
