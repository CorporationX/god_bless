package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String name, SpellAction action) {
        System.out.println(action.act(name));
    }
}
