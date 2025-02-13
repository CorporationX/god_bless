package school.faang.BJS2_57403;

public class Main {
    private static final String STUPEFY_SPELL = "The target is stunned by ";
    private static final String ACCIO_SPELL = "The object is summoned to the caster by ";
    private static final String REPARO_SPELL = "The broken object is mended by ";
    private static final String STUPEFY = "Stupefy";
    private static final String ACCIO = "Accio";
    private static final String REPARO = "Reparo";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(STUPEFY, ((spell) -> STUPEFY_SPELL + STUPEFY));
        spellCaster.cast(ACCIO, ((spell) -> ACCIO_SPELL + ACCIO));
        spellCaster.cast(REPARO, ((spell) -> REPARO_SPELL + REPARO));
    }
}
