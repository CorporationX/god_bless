package school.faang.task211.spells;

public class SpellCaster {
    public void cast(String spell, SpellAction sa) {
        System.out.println(sa.cast(spell));
    }
}
