package school.faang.sprint_2.task_45488;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String lumos = "Lumos";
        String ascendio = "Ascendio";
        String bombarda = "Bombarda";

        spellCaster.cast(lumos, spellName -> "A beam of light is created by " + spellName);
        spellCaster.cast(ascendio, spellName -> "Lifts the caster high into the air by " + spellName);
        spellCaster.cast(bombarda, spellName -> "Creates a large explosion capable of removing entire walls by "
                + spellName);
    }
}