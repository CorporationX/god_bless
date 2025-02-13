package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        try {
            spellCaster.cast(Spell.ALOHOMORA.getSpell(), spell -> "The door is unlocked by " + spell);
            spellCaster.cast(Spell.LUMOS.getSpell(), spell -> "A beam of light is created by " + spell);
            spellCaster.cast(Spell.EXPELLIARMUS.getSpell(), spell -> "The opponent is disarmed by " + spell);
            spellCaster.cast(null, spell -> "The opponent is disarmed by " + spell);
        } catch (IllegalArgumentException e) {
            System.out.printf(e.getMessage());
        }

    }
}
