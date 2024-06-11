package faang.school.godbless.hogvards;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.action(spellName));
    }
}
