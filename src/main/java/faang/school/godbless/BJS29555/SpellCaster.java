package faang.school.godbless.BJS29555;

public class SpellCaster {
    void cast(String spellName, SpellAction action) {
        System.out.println(action.activate(spellName));
    }
}
