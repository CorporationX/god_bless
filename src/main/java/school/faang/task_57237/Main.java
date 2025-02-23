package school.faang.task_57237;

public class Main {
    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("", spell -> "The door is unlocked by " + spell);
        spellCaster.cast("Lumos", (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast("Expelliarmus", (spell) -> "The opponent is disarmed by " + spell);
    }
}
