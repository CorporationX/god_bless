package functions.hogwarts;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The lock was open by " + spell);
        spellCaster.cast(lumos, (spell) -> "Lamp was turned on by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "Wizard lost his wand by " + spell);
    }
}
