package faang.school.godbless.hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.spell(spell));
    }
}
