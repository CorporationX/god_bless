package school.faang.bjs270242;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spellName) -> String.format("The door is unlocked by %s", spellName));
        spellCaster.cast(lumos, (spellName) -> String.format("A beam of light is created by %s", spellName));
        spellCaster.cast(expelliarmus, (spellName) -> String.format("The opponent is disarmed by %s", spellName));
    }
}
