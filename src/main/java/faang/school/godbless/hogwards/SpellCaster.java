package faang.school.godbless.hogwards;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }
}
