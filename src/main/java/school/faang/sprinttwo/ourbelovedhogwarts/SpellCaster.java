package school.faang.sprinttwo.ourbelovedhogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.printf("Результат заклинания - %s\n", result);
    }
}