package faang.school.godbless.hogwards;

public class SpellCaster {
    public String cast(String spell, SpellAction spellAction) {
        String resultAction = spellAction.action(spell);
        System.out.println(resultAction);
        return spellAction.action(spell);
    }
}
