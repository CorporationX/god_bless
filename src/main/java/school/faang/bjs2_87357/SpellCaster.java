package school.faang.bjs2_87357;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Заклинание школы " + result);
    }
}
