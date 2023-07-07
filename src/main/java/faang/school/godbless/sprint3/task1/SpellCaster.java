package faang.school.godbless.sprint3.task1;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.cast(spellName);
        System.out.println(result);
    }
}
