package school.faang.lambda_example;

public class SpellCaster {
    public void cast(String spellName, SpellAction spell) {
        String result = spell.castSpell(spellName);
        System.out.println("The result of the spell is: " + result);
    }
}
