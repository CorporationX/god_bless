package school.faang.hogwart;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms an object");
        hogwartsSpells.addSpellEvent("Protection", "Creates a protective barrier");
        hogwartsSpells.addSpellEvent("Enchantment", "Protects against attacks");

        log.info("All spells:");
        hogwartsSpells.printAllSpellEvents();

        log.info("Spell with ID {}:", 2);
        SpellEvent spellEventById = hogwartsSpells.getSpellEventById(2);
        log.info(spellEventById.toString());

        log.info("\nSpells type 'Protection':");
        List<SpellEvent> protection = hogwartsSpells.getSpellEventsByType("Protection");
        for (SpellEvent spellEvent : protection) {
            log.info(spellEvent.toString());
        }

        hogwartsSpells.deleteSpellEventById(1);
        log.info("Deleting a spell with ID {}:", 1);
        hogwartsSpells.printAllSpellEvents();
    }
}