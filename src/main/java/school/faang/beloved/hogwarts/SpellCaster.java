package school.faang.beloved.hogwarts;

public class SpellCaster {
    @FunctionalInterface
    interface SpellAction {
        String perform(String spellName);
    }

    public void cast(String spell, SpellAction action) {
        System.out.println(action.perform(spell));
    }
}
