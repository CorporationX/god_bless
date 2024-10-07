package dima.evseenko.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(Spell.ALOHOMORA, spell -> "The door is unlocked by " + spell);
        spellCaster.cast(Spell.LUMOS, spell -> "A beam of light is created by " + spell);
        spellCaster.cast(Spell.EXPELLIARMUS, spell -> "The opponent is disarmed by " + spell);
    }
}
