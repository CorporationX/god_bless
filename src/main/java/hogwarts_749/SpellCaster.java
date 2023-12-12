package hogwarts_749;

public class SpellCaster {

    public void cast(String str, SpellAction action) {
        System.out.println(action.spell(str));
    }
}