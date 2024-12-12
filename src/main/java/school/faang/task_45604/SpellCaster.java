package school.faang.task_45604;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.executeSpell(spellName);
        System.out.println("result: " + result);
    }
}
