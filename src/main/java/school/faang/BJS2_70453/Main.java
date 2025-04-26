package school.faang.BJS2_70453;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String accio = "Accio";
        String oculusReparo = "Oculus Reparo";

        spellCaster.cast(accio, (spell) -> "Summons an object towards the caster.");
        spellCaster.cast(oculusReparo, (spell) -> "Mends eyeglasses.");
    }
}
