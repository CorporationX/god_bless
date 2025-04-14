package school.faang.bjs2_70190;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> String.format("The door is unlocked by %s", spell));
        spellCaster.cast(lumos, (spell) -> String.format("A beam of light is created by %s", spell));
        spellCaster.cast(expelliarmus, (spell) -> String.format("The opponent is disarmed by %s", spell));
    }
}