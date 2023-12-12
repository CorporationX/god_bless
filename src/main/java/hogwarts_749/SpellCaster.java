package hogwarts_749;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println(action.spell(spell));
    }
}