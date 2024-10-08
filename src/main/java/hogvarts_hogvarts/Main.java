package hogvarts_hogvarts;

public class Main {

    public static void main(String[] args) {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        SpellCaster.cast(alohomora, spell -> "The door is unlocked by " + spell);
        SpellCaster.cast(lumos, spell -> "A beam of light is created by " + spell);
        SpellCaster.cast(expelliarmus, spell -> "The opponent is disarmed by " + spell);
    }
}
