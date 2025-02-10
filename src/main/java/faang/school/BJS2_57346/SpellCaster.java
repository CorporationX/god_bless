package faang.school.BJS2_57346;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println("Spell " + spellName + " casted!" + action.act(spellName));
    }
}
