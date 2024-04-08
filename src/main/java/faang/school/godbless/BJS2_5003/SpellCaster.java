package faang.school.godbless.BJS2_5003;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.convert(spell));
    }
}

@FunctionalInterface
interface SpellAction{
    public String convert(String word);
}