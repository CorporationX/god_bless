package faang.school.godbless.BJS2_20926;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        var result = spellAction.perform(spellName);
        System.out.println(result);
    }
}
