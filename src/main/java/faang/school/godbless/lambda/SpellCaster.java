package faang.school.godbless.lambda;

public class SpellCaster {
    public void cast (String spell, SpellAction spellAction){
        System.out.println(spellAction.toSpellAction(spell));
    }
}
