package faang.school.godbless.spells;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.act(spellName));
    }
}
