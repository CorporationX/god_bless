package faang.school.godbless.hogvarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction ){
        System.out.println(spellAction.useSpell(spellName));
    }
}
