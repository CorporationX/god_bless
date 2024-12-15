package school.faang.task_45656;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.action(spellName));
    }
}
