package school.faang;

@FunctionalInterface
interface SpellAction {
    String perform(String spellName);
}

public class SpellCaster {
    void cast(String spellName, SpellAction action) {
        String result = action.perform(spellName);
        System.out.println(result);

    }
}

