package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println(action.spell(spellName));
    }
}
