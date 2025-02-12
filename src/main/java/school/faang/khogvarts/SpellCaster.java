package school.faang.khogvarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println(action.actionRun(spell));
    }
}
