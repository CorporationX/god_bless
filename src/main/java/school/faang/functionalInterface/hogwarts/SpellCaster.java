package school.faang.functionalInterface.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }
}
