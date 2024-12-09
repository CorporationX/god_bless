package school.faang.task_45548;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String effect = action.theEffectOfTheSpell(spellName);
        System.out.println(effect);
    }
}
