package school.faang.sprint2.bjs_45580;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String output = spellAction.cast(spellName);
        System.out.println(output);
    }
}
