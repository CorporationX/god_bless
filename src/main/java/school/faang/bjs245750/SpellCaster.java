package school.faang.bjs245750;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        try {
            String result = action.castSpell(spellName);
            System.out.println("Результат заклинания: " + result);
        } catch (NullPointerException ex) {
            System.out.println("The action cannot be null!!!");
        }
    }
}
