package faang.school.godbless.kxnvg.hogvarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }
}
