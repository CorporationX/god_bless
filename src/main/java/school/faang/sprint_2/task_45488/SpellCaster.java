package school.faang.sprint_2.task_45488;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println("Spell result: " + action.spellAction(spell));
    }
}