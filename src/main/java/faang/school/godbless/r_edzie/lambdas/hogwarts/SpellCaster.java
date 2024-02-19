package faang.school.godbless.r_edzie.lambdas.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.cast(spellName));
    }
}
