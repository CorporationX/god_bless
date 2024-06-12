package faang.school.godbless.lambdas1;

public class SpellCaster {
    public void cast(String name, SpellAction spell) {
        System.out.println(spell.action(name));
    }
}
