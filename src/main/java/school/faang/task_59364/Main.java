package school.faang.task_59364;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(SpellType.ALOHOMORA.getSpellName(), (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(SpellType.LUMOS.getSpellName(), (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(SpellType.EXPELLIARMUS.getSpellName(), (spell) -> "The opponent is disarmed by " + spell);
    }
}
