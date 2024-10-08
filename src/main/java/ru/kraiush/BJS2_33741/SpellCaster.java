package ru.kraiush.BJS2_33741;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String spellResult = action.castSpell(spellName);
        System.out.println(spellResult);
    }
}
