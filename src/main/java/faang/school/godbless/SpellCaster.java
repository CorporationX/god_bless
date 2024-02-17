package faang.school.godbless;

public class SpellCaster {


    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.perform(spell);
        System.out.println(result);
    }
}

@FunctionalInterface
interface SpellAction {
    String perform(String spell);
}
