package faang.school.godbless.hogwarts;

public class SpellCaster {
    public void cast(String name, SpellAction spellAction){
        String result = spellAction.spell(name);
        System.out.println(result);
    }
}
