package school.faang.bjs_70171;

public class Main {
    public static void main(String[] args) {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String petrificusTotalus = "Petrificus Totalus";

        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(alohomora, spell -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, spell -> "The room is enlightened by " + spell);
        spellCaster.cast(petrificusTotalus, spell -> "The opponent is petrified by " + spell);
    }
}
