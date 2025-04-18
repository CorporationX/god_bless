package school.faang.hogwarts;

public class SpellCaster {
    public String cast(String spellName, SpellAction action) {
        String result = action.spell(spellName);
        System.out.println(result);
        return result;
    }
}
