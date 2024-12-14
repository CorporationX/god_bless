package school.faang.sprint2.bjs245628;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String printSpell = action.act(spell);
        System.out.println(printSpell);
    }
}