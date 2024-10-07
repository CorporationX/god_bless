package hogwartsHogwarts;

public class SpellCaster {
    public void cast(String str, SpellAction action) {
        System.out.println(action.cast(str));
    }
}
