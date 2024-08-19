package faang.school.functionalinterfaces;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(null, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, null);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
