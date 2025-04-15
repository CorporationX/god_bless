package school.faang.bjs270242;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spellName) -> "The door is unlocked by " + spellName);
        spellCaster.cast(lumos, (spellName) -> "A beam of light is created by " + spellName);
        spellCaster.cast(expelliarmus, (spellName) -> "The opponent is disarmed by " + spellName);
    }
}
