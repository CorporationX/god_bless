package faang.school.godbless;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        String result = action.spellAct(spell);
        System.out.println(result);
    }
}
