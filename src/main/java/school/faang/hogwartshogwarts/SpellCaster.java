package school.faang.hogwartshogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellCasting) {
        if (spellName == null) {
            throw new IllegalArgumentException("Spell name are null!");
        } else if (spellCasting == null) {
            throw new IllegalArgumentException("Spell casting are null!");
        } else {
            String spell = spellCasting.action(spellName);
            System.out.println(spell);
        }
    }
}
