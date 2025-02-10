package task_BJS2_57276;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String forbiddenSpell = "Avadakedavra";

        spellCaster.cast(alohomora, (spellName) -> String.format("The door is unlocked by %s", spellName));
        spellCaster.cast(lumos, (spellName) -> String.format("A beam of light is created by %s", spellName));
        spellCaster.cast(forbiddenSpell, (spellName) -> String.format("Cedric was killed by %s", spellName));
        spellCaster.cast(forbiddenSpell, null);
    }
}
