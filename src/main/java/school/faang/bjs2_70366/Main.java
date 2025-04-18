package school.faang.bjs2_70366;

public class Main {

    private static final String ALOHOMORA = "Alohomora";
    private static final String LUMOS = "Lumos";
    private static final String EXPELLIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();



        spellCaster.cast(ALOHOMORA, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(LUMOS, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(EXPELLIARMUS, (spell) -> "The opponent is disarmed by " + spell);
    }
}