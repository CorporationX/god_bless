package school.faang.bjs2_70366;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        if (spellName == null || action == null) {
            throw new IllegalArgumentException("Spell name and action cannot be null");
        }
        String result = action.perform(spellName);
        System.out.println(result);
    }
}