package school.faang.hogwarts2sprint;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        String resultOfSpell = spellAction.doSpell(spell);
        System.out.println(resultOfSpell);
    }
}


