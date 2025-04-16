package school.faang.BJS2_70262;

public class SpellCaster {
    public void cast(String name, SpellAction spellAction) {
        String spell = spellAction.cast(name);
        System.out.println(spell);
    }
}

