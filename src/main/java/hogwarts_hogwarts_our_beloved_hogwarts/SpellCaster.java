package hogwarts_hogwarts_our_beloved_hogwarts;


public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.cast(spell);
        System.out.println(result);
    }
}
