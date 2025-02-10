package school.faang.Task_Hogvorts_Horvorts_BJS2_59522;

public class SpellCaster  {

    public void castSpell(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Результат заклинание " + result);
    }
}
