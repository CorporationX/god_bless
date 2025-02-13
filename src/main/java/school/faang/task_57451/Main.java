package school.faang.task_57451;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String fireball = "Fireball";
        String frostbolt = "Frostbolt";
        String lightning = "Lightning";

        spellCaster.cast(fireball, (spell -> "A fiery " + spell + " launches!"));
        spellCaster.cast(frostbolt, (spell -> "An icy " + spell + " strikes!"));
        spellCaster.cast(lightning, (spell -> "A fierce " + spell + " crashes!"));
    }
}
