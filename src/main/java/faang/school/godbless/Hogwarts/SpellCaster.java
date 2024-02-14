package faang.school.godbless.Hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        String result = action.castSpell(spell);
        System.out.println(result);
    }
}
