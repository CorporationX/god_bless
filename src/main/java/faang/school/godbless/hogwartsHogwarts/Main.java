package faang.school.godbless.hogwartsHogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        SpellAction spellAlohomora = (spell) -> "The door is unlocked by " + spell;
        SpellAction spellLumos = (spell) -> "A beam of light is created by " + spell;
        SpellAction spellExpelliarmus = (spell) -> "The opponent is disarmed by " + spell;

        spellCaster.cast("Alohomora", spellAlohomora);
        spellCaster.cast("Lumos", spellLumos);
        spellCaster.cast("Expelliarmus ", spellExpelliarmus);
    }
}