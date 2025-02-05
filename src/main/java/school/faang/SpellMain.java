package school.faang;

import school.faang.bjs2_57010.HogwartsSpells;
import school.faang.bjs2_57010.SpellEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellMain {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        Map<Integer, SpellEvent> spellById = new HashMap<>();
        Map<String, List<SpellEvent>> spellByType = new HashMap<>();

        hogwartsSpells.addSpellEvent("Spell_1", "Action_1", spellById, spellByType);
        hogwartsSpells.addSpellEvent("Spell_2", "Action_2", spellById, spellByType);
        hogwartsSpells.addSpellEvent("Spell_1", "Action_4", spellById, spellByType);
        hogwartsSpells.addSpellEvent("Spell_2", "Action_5", spellById, spellByType);
        hogwartsSpells.addSpellEvent("Spell_3", "Action_3", spellById, spellByType);

        hogwartsSpells.getSpellEventById(1, spellById);
        separator();
        hogwartsSpells.getSpellByType("Spell_2", spellByType);
        separator();
        hogwartsSpells.deleteSpellEvent(5, spellById, spellByType);
        hogwartsSpells.getSpellByType("Spell_3", spellByType);
        separator();
        hogwartsSpells.getSpellEventById(5, spellById);
        separator();
        hogwartsSpells.printAllSpellEvents(spellById);
    }

    static void separator() {
        System.out.println("=============================");
    }
}
