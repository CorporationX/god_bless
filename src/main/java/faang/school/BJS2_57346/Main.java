package faang.school.BJS2_57346;

public class Main {
    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> " The door is unlocked!");
        spellCaster.cast(lumos, (spell) -> " A beam of light is created!");
        spellCaster.cast(expelliarmus, (spell) -> " The opponent is disarmed!");
    }
}
