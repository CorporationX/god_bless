package school.faang.bjs2_70310;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by %s".formatted(spell));
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by %s".formatted(spell));
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by %s".formatted(spell));
    }
}
