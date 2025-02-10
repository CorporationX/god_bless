package school.faang.hogwarts.hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        checkValidSpell(spell);
        checkValidSpellAction(spellAction);
        System.out.println(spellAction.castSpell(spell));
    }

    private void checkValidSpell(String spell) {
        if (spell == null && spell.isBlank()) {
            throw new IllegalArgumentException("The spell cannot be empty.");
        }
    }

    private void checkValidSpellAction(SpellAction spellAction) {
        if (spellAction == null) {
            throw new IllegalArgumentException("The spell action cannot be null.");
        }
    }
}
