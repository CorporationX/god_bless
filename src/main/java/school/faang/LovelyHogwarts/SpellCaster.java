package school.faang.LovelyHogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action){
        System.out.println(action.act(spell) + " spell");
    }
}
