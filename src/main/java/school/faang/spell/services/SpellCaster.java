package school.faang.spell.services;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.spellResult(spell);
        System.out.println(result);
    }
}
