package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String resultOfSpell = action.conjure(spell);
        System.out.println(resultOfSpell);
    }
}
