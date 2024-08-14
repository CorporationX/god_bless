package faang.school.godbless.bjs2_20843;

public class Main {
    public static void main(String[] args) {
        var spellCaster = new SpellCaster();

        spellCaster.cast("Alohomora", spell -> "The door is unlocked by " + spell);
        spellCaster.cast("Lumos", spell -> "A beam of light is created by " + spell);
        spellCaster.cast("Expelliarmus", spell -> "The opponent is disarmed by " + spell);
    }
}
