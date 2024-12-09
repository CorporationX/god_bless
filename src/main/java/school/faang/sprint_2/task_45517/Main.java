package school.faang.sprint_2.task_45517;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        spellCaster.cast(alohomora, (spellName) -> "The door is unlocked by " + spellName);
    }
}
