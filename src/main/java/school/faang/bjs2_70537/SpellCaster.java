package school.faang.bjs2_70537;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.spell(spellName);
        System.out.println("Результат заклинания '" + spellName + "': " + result);
    }

}
