package faang.school.godbless.HogwartsHogwarts2510;

public class Main {
    static final String ALOHOMORA = "Alohomora";
    static final String LUMOS = "Lumos";
    static final String EXPELLIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster test = new SpellCaster();
        test.cast(ALOHOMORA, (spell) -> "Open the door: " + spell);
        test.cast(LUMOS, (spell) -> "Let the light be: " + spell);
        test.cast(EXPELLIARMUS, (spell) -> "Drop your wand mf: " + spell);
    }
}