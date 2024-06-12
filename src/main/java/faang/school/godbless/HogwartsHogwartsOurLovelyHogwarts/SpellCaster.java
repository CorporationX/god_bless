package faang.school.godbless.HogwartsHogwartsOurLovelyHogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spell);
        System.out.println(spellAction.action(spell));
    }
}