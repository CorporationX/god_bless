package school.faang.bjs2_70274;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("Alohomora", (spell) -> String.format("The door is unlocked by %s", spell));
        spellCaster.cast("Lumos", (spell) -> String.format("A beam of light is created by %s", spell));
        spellCaster.cast("Expelliarmus", (spell) -> String.format("The opponent is disarmed by %s", spell));
    }
}