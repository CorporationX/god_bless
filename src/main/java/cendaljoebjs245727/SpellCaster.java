package cendaljoebjs245727;

public class SpellCaster {

    public void viewCast(String spellName, SpellAction action) {
        String result = action.showSpell(spellName);
        System.out.println(result);
    }

}

