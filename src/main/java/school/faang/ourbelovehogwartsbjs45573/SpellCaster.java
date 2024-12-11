package school.faang.ourbelovehogwartsbjs45573;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Result: " + result);
    }
}
