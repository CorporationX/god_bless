package school.faang.sweetHogwars;

public class SpellCaster {
    void cast(String spellName, spellAction action) {
        String result = action.perform(spellName);
        System.out.println(result);

    }
}

