package faang.school.godbless.hogvarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.cast(spell));
    }
}