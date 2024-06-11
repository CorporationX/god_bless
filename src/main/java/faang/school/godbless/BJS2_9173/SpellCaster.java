package faang.school.godbless.BJS2_9173;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        String spellAndAction = action.cast(spell);
        System.out.println(spellAndAction);
    }
}
