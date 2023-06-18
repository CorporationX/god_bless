package faang.school.godbless.secondSprint.Hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.cast(spellName));
    }

    @FunctionalInterface
    public interface SpellAction {
        String cast(String spellName);
    }
}
