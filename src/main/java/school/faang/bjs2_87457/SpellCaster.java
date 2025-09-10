package school.faang.bjs2_87457;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.printf("Результат заклинания: %s%n", action.castSpell(spellName));
    }
}
