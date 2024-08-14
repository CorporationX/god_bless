package hogvards;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println("Было вызвано: " + action.cast(spell));
    }
}
