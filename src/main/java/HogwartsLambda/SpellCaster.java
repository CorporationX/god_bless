package HogwartsLambda;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println(action.doMagic(spell));
    }
}
