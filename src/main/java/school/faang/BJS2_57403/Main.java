package school.faang.BJS2_57403;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String stupefy = "Stupefy";
        String accio = "Accio";
        String reparo = "Reparo";

        spellCaster.cast(stupefy, ((spell) -> "The target is stunned by " + stupefy + "!"));
        spellCaster.cast(accio, ((spell) -> "The object is summoned to the caster by " + accio + "!"));
        spellCaster.cast(reparo, ((spell) -> "The broken object is mended by " + reparo + "!"));
    }
}
