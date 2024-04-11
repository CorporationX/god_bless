package faang.school.godbless.hogwarts_hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null || spellName.isEmpty()) {
            throw new IllegalArgumentException("Параметр spellName не может быть null или пустым");
        }
        System.out.println(spellAction.action(spellName));
    }
}
