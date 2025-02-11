package school.faang.BJS2_57284;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        if (spellName == null || action == null) {
            throw new IllegalArgumentException("spellName or action can't be null");
        }

        String result = action.perform((spellName));
        System.out.println(result);
    }
}
