package school.faang.bjs2_80210;


public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String accio = "Accio";
        String levioso = "Levioso";
        String alohomora = "Alohomora";

        spellCaster.cast(accio, spell -> "The magic wand is summoned towards the caster by " + spell);
        spellCaster.cast(levioso, spell -> "The feather is raised up by " + spell);
        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
    }
}
