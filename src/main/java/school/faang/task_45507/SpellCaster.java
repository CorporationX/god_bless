package school.faang.task_45507;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.castSpell(spellName);
        System.out.printf("Spell result: %s%n", result);
    }

}
