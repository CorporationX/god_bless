package school.faang.hogwardshogwards;

public class Main {
    public static void main(String[] args) {
        String accio = "Accio";
        String nox = "Nox";
        String avadaKedavra = "Avada Kedavra";
        String makingAlive = "Making alive spell";

        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(accio, (spell) -> "The object was found by " + spell);
        spellCaster.cast(nox, (spell) -> "The light was turned off by " + spell);
        spellCaster.cast(avadaKedavra, (spell) -> "The man was killed by " + spell);
        spellCaster.cast(makingAlive, (spell) -> "The man became alive by " + spell);
    }
}
