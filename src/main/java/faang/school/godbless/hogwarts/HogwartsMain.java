package faang.school.godbless.hogwarts;

public class HogwartsMain {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String bombardaMaxima = "Bombarda Maxima";
        String nox = "Nox";
        String aquaEructo = "Aqua Eructo";

        spellCaster.cast(bombardaMaxima, (spell) -> "Volodya Morda was eliminated by " + spell);
        spellCaster.cast(nox, (spell) -> "Flashlight was turned off by " + spell);
        spellCaster.cast(aquaEructo, (spell) -> "Volodya Morda was washed by " + spell);
    }
}