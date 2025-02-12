package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        if (spellName.isBlank()) {
            throw new IllegalArgumentException("SpellName cannot be empty!");
        }
        String result = action.spellCast(spellName);
        System.out.println(result);
    }
}
