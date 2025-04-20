package school.faang.bjs270115;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.castSpell(spellName);
        System.out.println("Result: " + result);
    }
}
