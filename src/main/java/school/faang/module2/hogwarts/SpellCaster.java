package school.faang.module2.hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.cast(spell));
    }
}
