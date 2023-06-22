package Hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster wizard = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        wizard.cast(alohomora,(spell) -> "The door is unlocked by " + spell);
        wizard.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        wizard.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
