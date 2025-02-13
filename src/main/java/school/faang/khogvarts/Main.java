package school.faang.khogvarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(SpellConstants.alohomora, spell -> "The door is unlocked by " + spell);
        spellCaster.cast(SpellConstants.lumos, spell -> "A beam of light is created by " + spell);
        spellCaster.cast(SpellConstants.expelliarmus, spell -> "The opponent is disarmed by " + spell);
    }
}
