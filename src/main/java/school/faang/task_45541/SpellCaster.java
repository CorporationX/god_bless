package school.faang.task_45541;

public class SpellCaster{
    public void cast(String spell, SpellAction action){
        String result = action.act(spell);
        System.out.println(result);
    }
}
