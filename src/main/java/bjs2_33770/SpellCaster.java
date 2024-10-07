package bjs2_33770;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println(action.doMagic(spell));
    }
}
