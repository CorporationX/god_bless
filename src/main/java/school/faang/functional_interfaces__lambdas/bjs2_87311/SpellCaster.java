package school.faang.functional_interfaces__lambdas.bjs2_87311;

public class SpellCaster {
    void cast(String spellName, SpellAction spell) {
        String castSpell = spell.castSpell(spellName);
        System.out.println(castSpell);
    }
}
