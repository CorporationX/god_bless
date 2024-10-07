package school.faang.bjs2_33768;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.castSpell(spellName);
        System.out.println("Результат заклинание: " + result);
    }
}
