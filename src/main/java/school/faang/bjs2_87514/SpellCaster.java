package school.faang.bjs2_87514;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        if (action == null) {
            throw new IllegalArgumentException("Spell action must not be null");
        }
        String result = action.apply(spellName);
        if (result == null) {
            System.out.println("The spell didn't work");
            return;
        }
        System.out.println(result);
    }
}
