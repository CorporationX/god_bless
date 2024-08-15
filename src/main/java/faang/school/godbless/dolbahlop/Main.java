package faang.school.godbless.dolbahlop;

public class Main {
    public static void main(String[] args) {
        var SpellCaster  = new SpellCaster();

        String alohomora = "Alohomora";
        String lumus = "Lumus";
        String expelliarmus = "expelliarmus";

        SpellCaster.cast(alohomora, (spell -> "The door is unlocked by" + spell));
        SpellCaster.cast(lumus, spell -> "A beam of light is created by" + spell);
        SpellCaster.cast(expelliarmus, spell -> "The opponent is disarmed by" + spell);
    }
}
