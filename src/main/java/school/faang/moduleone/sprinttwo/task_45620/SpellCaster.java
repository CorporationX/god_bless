package school.faang.moduleone.sprinttwo.task_45620;

public class SpellCaster {
    public String cast(String spellName, SpellAction action) {
        String result = action.action(spellName);
        System.out.println(result);
        return result;
    }
}
