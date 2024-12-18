package school.faang.task_45667;

public class SpellCaster {
    private String fullSpell;

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }
}