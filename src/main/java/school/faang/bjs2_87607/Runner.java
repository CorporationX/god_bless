package school.faang.bjs2_87607;

public class Runner {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();
        caster.cast("Ice shot", spellName ->  "freezes enemies");
        caster.cast("Lightning arrow", spellName -> "shocks enemies");
        caster.cast("Cyclone", spellName -> "annihilates enemies");
        caster.cast("Hexblast", spellName -> "forces your mom laugh");
    }
}
