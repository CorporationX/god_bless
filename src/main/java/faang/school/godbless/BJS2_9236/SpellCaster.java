package faang.school.godbless.BJS2_9236;

public class SpellCaster {
    void cast(String spellName, SpellAction spellAction) {
        String castResult = spellAction.tell(spellName);
        System.out.println(castResult);
    }
}
