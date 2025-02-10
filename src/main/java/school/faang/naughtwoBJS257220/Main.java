package school.faang.naughtwoBJS257220;

public class Main {
    public static final String alohomora = "Alohomora";
    public static final String lumos = "Lumos";
    public static final String expelliarmus = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
