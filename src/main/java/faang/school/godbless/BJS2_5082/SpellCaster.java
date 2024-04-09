package faang.school.godbless.BJS2_5082;

public class SpellCaster {
    public static void cast(String spellName, SpellAction action){
        System.out.println("Заклинание: " + spellName + action.doSpell(spellName));
    }
}
