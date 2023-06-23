package faang.school.godbless.sprint3.lambdas.Hogwarts.classes;

import faang.school.godbless.sprint3.lambdas.Hogwarts.interfaces.SpellAction;

public class SpellCaster {
    public static final String SPELL_IS_NULL_EXCEPTION = "Spell is null";

    public static final String SPELL_IS_EMPTY_EXCEPTION = "Spell is empty";
    public String cast(String spell, SpellAction action){
        if (spell == null){
            throw new IllegalArgumentException(SPELL_IS_NULL_EXCEPTION);
        }
        if (spell.isEmpty()){
            throw new IllegalArgumentException(SPELL_IS_EMPTY_EXCEPTION);
        }
       return action.cast(spell);
    }
}
