package school.faang.stream2.hogwartsspellcaster;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.cast(spellName));
    }
}
