package faang.school.godbless.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.perform(spellName);
        System.out.println("Spell " + spellName + " result: " + result);
    }
}
