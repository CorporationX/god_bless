package beloved_hogwarts;

public class SpellCaster {
    private static final SpellCaster spellCaster = new SpellCaster();

    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.spell(spell);
        System.out.println("заклиание прменено: " + result);
    }
}

