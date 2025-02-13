package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        if (action == null || spell == null) {
            throw new IllegalArgumentException("Spell casting failed");
        }
        String resultOfSpell = action.conjure(spell);
        System.out.println(resultOfSpell);
    }
}
