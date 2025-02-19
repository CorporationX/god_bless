package school.faang.hogwarts_hogwarts;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(Spell.ALOHAMORA.name(), (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(Spell.LUMOS.name(), (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(Spell.EXPELIARMUS.name(), (spell) -> "The opponent is disarmed by " + spell);
    }
}
