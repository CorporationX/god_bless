package school.faang.hogwartshogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellCasting) {
        String spell = spellCasting.action(spellName);
        System.out.println(spell);
    }
}
