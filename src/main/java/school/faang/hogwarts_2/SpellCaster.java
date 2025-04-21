package school.faang.hogwarts_2;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        String action = spellAction.cast(spell);
        System.out.println("Spell:" + action);
    }
}
