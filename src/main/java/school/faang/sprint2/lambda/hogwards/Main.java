package school.faang.sprint2.lambda.hogwards;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Lumos", (spell) -> "A beam of light is created by " + spell);
        System.out.println();
        spellCaster.cast("Alohomora", (spell) -> "The door is unlocked by " + spell);
    }
}
