package school.faang.hogwarts;

public class SpellCaster {

    public void cast(String name, SpellAction spellAction) {
        System.out.println(spellAction.spell(name));
    }
}
