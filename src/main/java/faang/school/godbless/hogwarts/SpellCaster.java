package faang.school.godbless.hogwarts;

public class SpellCaster {
    void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.runSpell(spellName);
        System.out.println(result);
    }
}
