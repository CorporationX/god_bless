package school.faang.task_BJS2_57471;

public class Main {
    public static final String ALOHOMORA = "Alohomora";
    public static final String LUMOS = "Lumos";
    public static final String EXPELLIIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(ALOHOMORA, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(LUMOS, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(EXPELLIIARMUS, (spell) -> "The opponent is disarmed by " + spell);
    }
}
