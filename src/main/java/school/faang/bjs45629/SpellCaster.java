package school.faang.bjs45629;

public class SpellCaster {
    public void cast(String name, SpellAction action) {
        if (action == null) {
            return;
        }
        System.out.println(action.castSpell(name));
    }
}
