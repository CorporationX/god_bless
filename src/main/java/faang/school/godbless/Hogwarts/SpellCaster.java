package faang.school.godbless.Hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.cast(spellName);
        System.out.println(result);
    }
}
