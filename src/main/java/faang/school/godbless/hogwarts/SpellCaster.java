package faang.school.godbless.hogwarts;

public class SpellCaster {
    public void cast(String param,SpellAction action){
        String res = action.act(param);
        System.out.println(res);
    }
}
