package faang.school.godbless.sprint2.hogvarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction){
        System.out.println(spellAction.action(spell));
    }
}
