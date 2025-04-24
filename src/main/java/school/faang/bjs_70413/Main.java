package school.faang.bjs_70413;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("SimSim", spellName -> {
            return "The door opened";
        });

        spellCaster.cast("Health", spellName -> {
            return "Hundred people were cured";
        });

        spellCaster.cast("Teleport", spellName -> {
            return "Instant movement";
        });

        spellCaster.cast("Invisibility", spellName -> {
            return "Become invisible to your enemies";
        });
    }
}
