package school.faang.LovelyHogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String fireBall = "fire ball";
        String icePick = "ice pick";
        String thunderBolt = "thunder bolt";

        spellCaster.cast(fireBall, (spell) -> "Flamed by " + spell);
        spellCaster.cast(icePick, (spell) -> "Pierced by " + spell);
        spellCaster.cast(thunderBolt, (spell) -> "999999 damage brings " + spell);
    }

}
