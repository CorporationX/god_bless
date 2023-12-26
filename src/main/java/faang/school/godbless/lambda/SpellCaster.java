package faang.school.godbless;

public class SpellCaster {
    public void cast (String spell, SpellAction spellAction){
        System.out.println(spellAction.toSpellAction(spell));
    }
}
