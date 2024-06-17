package faang.school.godbless.hogvarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.action(spell);
        System.out.println(result);

    }
}
