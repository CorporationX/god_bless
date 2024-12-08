package school.faang.sprint_2.task_45454;

public class SpellCaster {
    void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.printf("Spell result: %s\n", result);
    }
}

