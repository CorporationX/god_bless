package school.faang.bjs2_87477;

public class SpellCaster {
    void cast(String spellName, SpellAction spellAction) {
        String castResult = spellAction.cast(spellName);
        System.out.println(castResult);
    }
}
