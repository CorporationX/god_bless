package school.faang.task_44573;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        for (int i = 0; i < 10; i++) {
            Map<String, String> randomSpell = Spells.getRandomSpell();
            SpellEvent spellEvent = SpellEvent.builder()
                    .id(i)
                    .eventType(randomSpell.get("eventType"))
                    .eventDescription(randomSpell.get("eventDescription"))
                    .build();
            hogwartsSpells.addSpellEvent(spellEvent);
        }

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.printingOutTheSpellsByTypeMap();

        System.out.println(" ");

        System.out.println("list of spells by type 'Dispel Magic' :: "
                + hogwartsSpells.getSpellEventsByType("Dispel Magic"));

        System.out.println(" ");

        System.out.println("list of spells by id '5' :: " + hogwartsSpells.getSpellEventById(5));

        System.out.println(" ");

        hogwartsSpells.deleteSpellEvent(8);

        System.out.println("Below is a printout of the both maps after I deleted spell by its id == 8 ::");

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.printingOutTheSpellsByTypeMap();
    }
}
