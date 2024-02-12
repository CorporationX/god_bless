package faang.school.godbless.hogwarts;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Alohomora", spell -> "The door is unlocked by " + spell);
    }
}
