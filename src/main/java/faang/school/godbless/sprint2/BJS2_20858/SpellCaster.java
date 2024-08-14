package faang.school.godbless.sprint2.BJS2_20858;

public class SpellCaster {
    protected void cast(String spellName, SpellAction action) {
        System.out.println(action.perform(spellName));
    }
}
