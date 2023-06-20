package faang.school.godbless;

public class SpellCaster {
    public void cast(String spell, SpellAction<String> action){
        System.out.println(action.cast(spell));
    }
}
