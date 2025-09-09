package school.faang.bjs2_87457;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println("Результат заклинания: " + action.castSpell(spellName));
    }
}
