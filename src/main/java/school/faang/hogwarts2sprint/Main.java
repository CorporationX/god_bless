package school.faang.hogwarts2sprint;

public class Main {
    public static void main(String[] args) {
        String imperio = "Imperio";
        String reparo = "Reparo";
        String protego = "Protego";
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(imperio, (spell) -> "Your will is under my control by " + spell);
        spellCaster.cast(reparo, (spell) -> "The broken item has been restored by " + spell);
        spellCaster.cast(protego, (spell) -> "The enemy spell was mirrored by " + spell);
    }
}
