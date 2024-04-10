package faang.school.godbless.hogwarts_hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null) {
            throw new NullPointerException("The value is missing");
        }
        if (spellName.isEmpty()) {
            throw new IllegalArgumentException("The meaning of the spell name is empty");
        }
        System.out.println(spellAction.action(spellName));
    }
}
