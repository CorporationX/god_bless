package faang.school.godbless.Sprint_3.hogwarts;

public class SpellCaster{
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.cast(spell));
    }

    @FunctionalInterface
    public interface SpellAction {
        String cast(String spell);
    }
}
