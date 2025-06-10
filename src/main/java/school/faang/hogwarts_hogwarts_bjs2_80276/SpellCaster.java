package school.faang.hogwarts_hogwarts_bjs2_80276;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.action(spellName);
        System.out.printf("Заклинание: %s\n", result);
    }
}
