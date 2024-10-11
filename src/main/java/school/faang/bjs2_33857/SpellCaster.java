package school.faang.bjs2_33857;

public class SpellCaster {

    public void castSpell(String spellName, SpellAction spellAction) {
        String result = spellAction.cast(spellName);
        System.out.println(result);
    }
}

