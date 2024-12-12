package school.faang.bjs245588;

public class Main {
    public static void main(String[] args) {
        SpellCastor spellCastor = new SpellCastor();

        String alohomora = "Alohomora";
        String lumus = "Lumus";
        String expiliarmus = "Expeliarmus";

        spellCastor.cast(alohomora, spellName -> "The door is unlocked by " + spellName);
        spellCastor.cast(lumus, spellName -> "A beam light is created by " + spellName);
        spellCastor.cast(expiliarmus, spellName -> "The opponent disarmed by " + spellName);
    }
}
