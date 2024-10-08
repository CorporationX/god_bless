package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String lumos = "Lumos";
        String alahomora = "Alohomora";

        spellCaster.cast(lumos, spell -> "A beam of lights is created by " + spell);
        spellCaster.cast(alahomora, spell -> "The door is unlocked by " + spell);
    }
}
