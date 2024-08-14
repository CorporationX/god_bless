package faang.school.godbless.hogwarts;

public class SpellCaster {
    public void cast(String name, SpellAction spellAction){
        System.out.println(spellAction.spellAction(name));
    }
}
