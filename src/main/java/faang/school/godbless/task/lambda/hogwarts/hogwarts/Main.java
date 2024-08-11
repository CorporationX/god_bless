package faang.school.godbless.task.lambda.hogwarts.hogwarts;

public class Main {
    public static void main(String... args) {
        var spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, spell -> "The door id unlocked by " + spell);
        spellCaster.cast(lumos, spell -> "A bean of light is created by " + spell);
        spellCaster.cast(expelliarmus, spell -> "The opponent is disarmed by " + spell);
    }
}
