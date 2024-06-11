package faang.school.godbless;

public class SpellCaster {
    protected void cast(String spell, SpellAction spellAction){
        System.out.println(spellAction.action(spell));
    }
}
