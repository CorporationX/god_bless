package faang.school.godbless.bjs2_20843;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.apply(spell));
    }
}
