package school.faang.bjs2_87514;

public class MainDemo {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("Alohomora", spell -> "The door is unlocked by " + spell);
        spellCaster.cast("Lumos", spell -> "A beam of light is created by " + spell);
        spellCaster.cast("Expelliarmus", spell -> "The opponent is disarmed by " + spell);
    }
}
