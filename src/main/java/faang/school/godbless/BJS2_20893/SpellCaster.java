package faang.school.godbless.BJS2_20893;

public class SpellCaster {
    public String cast(String spellName, SpellAction spellAction) {
        return spellAction.perform(spellName);
    }
}
