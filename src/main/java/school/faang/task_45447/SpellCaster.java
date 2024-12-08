package school.faang.task_45447;

public class SpellCaster {

    public String cast(String spellName, SpellAction spellAction) {
        return spellAction.action(spellName);
    }
}