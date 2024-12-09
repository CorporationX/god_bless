package school.faang.lovely_hogwarts;

public class Main {
    public static void main(String[] args) {
        String aguamenti = "Aguamenti";
        String herbifors = "Herbifors";
        String oppugno = "Oppugno";

        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(oppugno, (spellName) -> "The enemies is attacked by " + spellName);
        spellCaster.cast(herbifors, (spellName) -> "The flowers is sprouted by " + spellName);
        spellCaster.cast(aguamenti, (spellName) -> "The glass of clean water is created by " + spellName);
    }
}
