package school.faang.bjs2_80351;

public class Main {
    public static void main(String[] args) {

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        SpellCaster.cast(alohomora, spellName -> "The door is unlocked by " + spellName);
        SpellCaster.cast(lumos, spellName -> "A beam of light is created by " + spellName);
        SpellCaster.cast(expelliarmus, spellName -> "The opponent is disarmed by " + spellName);
    }
}
