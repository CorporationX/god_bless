package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String name, SpellAction spell) {
        System.out.println(spell.castMagic(name));
    }
}
