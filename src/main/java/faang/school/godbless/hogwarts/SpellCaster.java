package faang.school.godbless.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.execute(spellName);
        System.out.println(result);
    }
}