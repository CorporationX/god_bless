package school.faang.Hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        System.out.println(action.action(spell));
    }
}
