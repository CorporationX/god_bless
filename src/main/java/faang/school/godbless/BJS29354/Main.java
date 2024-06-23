package faang.school.godbless.BJS29354;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster("New Spell");

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell, s) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell, a) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell, b) -> "The opponent is disarmed by " + spell);
    }
}