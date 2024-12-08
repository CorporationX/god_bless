package school.faang.task_45451;

public class SpellCaster {
    public void cast(String cast, SpellAction spellAction) {
        String result = spellAction.resultOfSpell(cast);
        System.out.println(result);
    }
}
