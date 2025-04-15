package school.faang.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.apply(spellName);
        System.out.println(result);
    }
}