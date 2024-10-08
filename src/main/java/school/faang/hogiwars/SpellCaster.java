package school.faang.hogiwars;

public class SpellCaster {
    public void cast(String spellName, SpellCast action) {
        String spellResult = action.castSpell(spellName);
        System.out.println("My good spell " + spellResult);
    }
}
