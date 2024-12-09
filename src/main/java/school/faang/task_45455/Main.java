package school.faang.task_45455;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(spellCaster.getAlohomora(), (nameSpell) -> "The door is unlocked by " + nameSpell);
        spellCaster.cast(spellCaster.getLumos(), (nameSpell) -> "A beam of light is created by " + nameSpell);
        spellCaster.cast(spellCaster.getExpelliarmus(), (nameSpell) -> "The opponent is disarmed by " + nameSpell);
        spellCaster.cast("Люмус Максима", (nameSpell -> "Очень яркий свет с помощью " + nameSpell));
    }
}
