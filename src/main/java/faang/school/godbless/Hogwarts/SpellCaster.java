package faang.school.godbless.Hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.cast(spell);
        System.out.println(result);
    }
}
