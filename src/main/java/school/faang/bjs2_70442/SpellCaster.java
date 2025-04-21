package school.faang.bjs2_70442;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        System.out.println(action.apply(spell));
    }
}
