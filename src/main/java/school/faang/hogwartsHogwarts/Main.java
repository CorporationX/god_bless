package school.faang.hogwartsHogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String accio = "Accio!";
        String expelliarmus = "Expelliarmus!";
        String protego = "Protego!";
        String stupefy = "Stupefy!";
        String alohomora = "Alohomora!";

        spellCaster.cast(accio, (spell) -> "Summons objects " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "Knocks the magic wand out of the opponent's hands " + spell);
        spellCaster.cast(protego, (spell) -> "Creates a magical shield " + spell);
        spellCaster.cast(stupefy, (spell) -> "Stuns the opponent " + spell);
        spellCaster.cast(alohomora, (spell) -> "Unlocks locked doors " + spell);
    }
}
