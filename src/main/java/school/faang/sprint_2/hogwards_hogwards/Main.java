package school.faang.sprint_2.hogwards_hogwards;

public class Main {
    public static void main(String[] args) {
        SpellCaster.cast("Alohomora", (spell) -> "The door is unlocked by " + spell);
        SpellCaster.cast("Lumos", (spell) -> "A beam of light is created by " + spell);
        SpellCaster.cast("Expelliarmus", (spell) -> "The opponent is disarmed by " + spell);
    }
}
