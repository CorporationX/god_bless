package school.faang.naughtwoBJS257220;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        try {
            checkSpellName(spellName);
            checkSpellAction(spellAction);
            System.out.println(spellAction.castSpell(spellName));
        } catch (IllegalArgumentException e) {
            System.out.println("The input values are incorrect. " + e.getMessage());
        }
    }

    private void checkSpellName(String spellName) {
        if (spellName == null || spellName.isBlank()) {
            throw new IllegalArgumentException("Spell name cannot be empty or 'null'.");
        }
    }

    private void checkSpellAction(SpellAction spellAction) {
        if (spellAction == null) {
            throw new IllegalArgumentException("Spell action cannot be 'null'.");
        }
    }
}
