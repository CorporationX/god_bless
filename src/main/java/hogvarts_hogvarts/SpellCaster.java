package hogvarts_hogvarts;

public class SpellCaster {
    public static void cast(String spell, SpellAction action) {
        System.out.println(action.act(spell));
    }
}
