package school.faang.ourfavoritehogwarts;

public class App {
    public static final String ALOHOMORA = "Alohomora";
    public static final String LUNOS = "Lumos";
    public static final String EXPELLIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(ALOHOMORA, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(LUNOS, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(EXPELLIARMUS, (spell) -> "The opponent is disarmed by " + spell);
    }
}