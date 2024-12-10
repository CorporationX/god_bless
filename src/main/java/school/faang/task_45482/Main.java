package school.faang.task_45482;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        spellCaster.cast(alohomora, new SpellAction() {
            @Override
            public String castSpell(String spellName) {
                return "Main villain died by 'Avada Kedavra'";
            }
        });
    }
}
