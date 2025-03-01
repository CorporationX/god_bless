package school.faang.spellmanagement;

public class SpellCaster {

    public void cast(Spell spell, SpellAction action) {
        if (spell == null) {
            throw new IllegalArgumentException("A spell cannot be null.");
        }

        if (action == null) {
            throw new IllegalArgumentException("The effect of the spell (action) cannot be null.");
        }

        String result = action.castSpell(spell);
        System.out.println(result);
    }
}
