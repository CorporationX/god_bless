package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.cast(spellName));
    }
}
