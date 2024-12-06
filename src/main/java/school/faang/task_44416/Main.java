package school.faang.task_44416;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    private static final String[] TEST_SPELL_TYPES = {
            "Super_duper_spell", "idk Harry Poter",
            "NYAN!!!", "Japanese beam"};
    private static final String[] TEST_SPELL_ACTIONS = {
            "kill you", "Are you serious?",
            "かわいい!!!", "baaaaka"};
    private static final int SPELL_EVENTS_COUNT = 10;

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        Random rand = new Random();
        int spellNumber;
        for (int id = 0; id < SPELL_EVENTS_COUNT; id++) {
            spellNumber = rand.nextInt(TEST_SPELL_ACTIONS.length);
            hogwartsSpells.addSpellEvent(id, TEST_SPELL_TYPES[spellNumber], TEST_SPELL_ACTIONS[spellNumber]);
        }

        System.out.println(hogwartsSpells
                .getSpellEventById(
                        rand.nextInt(SPELL_EVENTS_COUNT)
                )
        );
        System.out.println(hogwartsSpells
                .getSpellEventsByType(
                        TEST_SPELL_TYPES[rand.nextInt(TEST_SPELL_TYPES.length)]
                )
        );

        hogwartsSpells.printAllSpellEvents();

        System.out.print('\n');

        hogwartsSpells.deleteSpellEvent(rand.nextInt(SPELL_EVENTS_COUNT));

        hogwartsSpells.printAllSpellEvents();
    }
}
