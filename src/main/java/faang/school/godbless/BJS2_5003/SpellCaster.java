package faang.school.godbless.BJS2_5003;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.convert(spell));
    }
}

@FunctionalInterface
interface SpellAction{
    String convert(String word);
}