package faang.school.godbless.secondsprint.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println(action.perform(spellName));
    }
}
