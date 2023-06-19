package faang.school.godbless.sprint2.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("Alohomora", a -> "The door is unlocked by" + a);
    }
}
