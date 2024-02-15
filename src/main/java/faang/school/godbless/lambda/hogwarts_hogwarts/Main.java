package faang.school.godbless.lambda.hogwarts_hogwarts;

public class Main {
    static final String ALOHOMORA = "Alohomora";
    static final String LUMOS = "Lumos";
    static final String EXPELLIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(ALOHOMORA, (spellName) -> "The door is unlocked by " + spellName);
        spellCaster.cast(LUMOS, (spellName) -> "A beam of light is created by " + spellName);
        spellCaster.cast(EXPELLIARMUS, (spellName) -> "The opponent is disarmed by " + spellName);
    }
}
