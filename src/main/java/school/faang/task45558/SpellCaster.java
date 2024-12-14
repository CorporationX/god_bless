package school.faang.task45558;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Результат заклинания : " + result);
    }
}
