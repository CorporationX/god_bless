package school.faang.hogwardshogwards;

public class Main {
    public static final String ACCIO = "Accio";
    public static final String NOX = "Nox";
    public static final String AVADA_KEDAVRA = "Avada Kedavra";
    public static final String MAKING_ALIVE = "Making alive spell";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(ACCIO, (spell) -> "The object was found by " + spell);
        spellCaster.cast(NOX, (spell) -> "The light was turned off by " + spell);
        spellCaster.cast(AVADA_KEDAVRA, (spell) -> "The man was killed by " + spell);
        spellCaster.cast(MAKING_ALIVE, (spell) -> "The man became alive by " + spell);
    }
}
