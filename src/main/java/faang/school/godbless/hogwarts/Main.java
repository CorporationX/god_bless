package faang.school.godbless.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("lumos", spell -> "The wand glows by " + spell);
    }
}
