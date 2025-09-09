package school.faang.bjs2_87336;

public class SpellCaster {

    private SpellCaster() {

    }

    public static void cast(String spell, SpellAction action) {
        System.out.println(action.castSpell(spell));
    }
}
