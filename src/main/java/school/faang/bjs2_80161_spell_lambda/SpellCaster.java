package school.faang.bjs2_80161_spell_lambda;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println(action.generateDescription(spell));
    }
}
