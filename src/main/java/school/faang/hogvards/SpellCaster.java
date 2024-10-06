package school.faang.hogvards;

public class SpellCaster {
    public void cast( String spell, SpellAction action) {
        System.out.println(action.cast(spell));
    }
}
