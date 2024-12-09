package school.faang.task_45482;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction){
        String result = spellAction.castSpell(spell);
        System.out.println(result);
    }
}
