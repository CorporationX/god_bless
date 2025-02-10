package school.faang.hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        validateInputs(spell, spellAction);

        System.out.println(spellAction.cast(spell));
    }

    private void validateInputs(String spell, SpellAction spellAction) {
        if (spell == null || spell.trim().isEmpty()) {
            throw new IllegalArgumentException("Spell is required");
        }
        if (spellAction == null) {
            throw new IllegalArgumentException("SpellAction is required");
        }
    }
}
