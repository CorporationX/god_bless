package faang.school.BJS2_57346;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(Spell.ALOHOMORA, (spell) -> "The door is unlocked!");
        spellCaster.cast(Spell.LUMOS, (spell) -> "A beam of light is created!");
        spellCaster.cast(Spell.EXPELLIARMUS, (spell) -> "The opponent is disarmed!");
    }
}