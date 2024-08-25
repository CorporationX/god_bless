package faang.school.godbless;

public class SpellCaster {
    public void cast(String name,SpellAction spellAction){
        System.out.println(spellAction.describe(name));
    }
}
