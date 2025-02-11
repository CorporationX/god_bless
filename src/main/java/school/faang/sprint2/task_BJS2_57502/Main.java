package school.faang.sprint2.task_BJS2_57502;

public class Main {
    private static final SpellCaster SPELL_CASTER = new SpellCaster();
    private static final String ALOHOMORA = "Alohomora";
    private static final String LUMOS = "Lumos";
    private static final String EXPELLIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SPELL_CASTER.cast(ALOHOMORA, (spell) -> "The door is unlocked by " + spell);
        SPELL_CASTER.cast(LUMOS, (spell) -> "A beam of light is created by " + spell);
        SPELL_CASTER.cast(EXPELLIARMUS, (spell) -> "The opponent is disarmed by " + spell);
    }
}
