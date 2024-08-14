package faang.school.godbless.BJS2_20929;

public class SpellCaster {
    public void cast(String spell, SpellAction action){
        String result = action.performSpell(spell);
        System.out.println("Spell: " + spell + " Result: " + result);
    }
}
