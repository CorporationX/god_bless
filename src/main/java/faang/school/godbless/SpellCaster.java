package faang.school.godbless;

public class SpellCaster {
    public void cast(String spell, ISpellAction action) {
        System.out.println(action.performSpell(spell));
    }
}
