package faang.school.BJS2_57346;

public class SpellCaster {
    public void cast(Spell spell, SpellAction action) {
        if (spell == null || action == null) {
            System.out.println("Error: Spell name or action cannot be null!");
            return;
        }
        System.out.printf("Casting spell: %s\nAction: %s\n", spell.getName(),
                action.executeSpell(spell.getName()));
    }
}