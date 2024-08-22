package faang.school.godbless.hogwards.spells;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.execute(spellName));
    }
}
