package school.faang.hogwards;

public class SpellCast {
    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.cast(spell);
        System.out.println("Результат заклинания: " + result);
    }
}
