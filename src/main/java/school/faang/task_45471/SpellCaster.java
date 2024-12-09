package school.faang.task_45471;

public class SpellCaster {
    public void cast(String spellName, SpellAction<String> spellAction) {
        System.out.println(spellAction.castSpell(spellName));
    }

}
