package school.faang.hogwarts_hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.castSpell(spellName);
        System.out.printf("Result of spell is: %s", result);

    }
}

