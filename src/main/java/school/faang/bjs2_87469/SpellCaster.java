package school.faang.bjs2_87469;

public class SpellCaster {
    void cast(String spellName, SpellAction action) {
        if (spellName == null || action == null) {
            return;
        }
        try {
            String result = action.execute(spellName);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Spell error");
        }
    }
}
