package school.faang.sprint_2.task_45517;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String spellResult = spellAction.spell(spellName);
        System.out.println(spellResult);
    }
}
