package faang.school.godbless.lamdbastreamapi.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doSpell(spellName));
    }
}
