package school.faang.task_45605;

public class SpellCaster {
    void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doAction(spellName));
    }
}
