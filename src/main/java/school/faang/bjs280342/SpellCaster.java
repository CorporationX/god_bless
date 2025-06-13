package school.faang.bjs280342;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.perform(spellName);
        System.out.println(result);
    }
}
