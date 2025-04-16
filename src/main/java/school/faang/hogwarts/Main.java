package school.faang.hogwarts;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, "The door is unlocked by%s"::formatted);
        spellCaster.cast(lumos, "A beam of light is created by%s"::formatted);
        spellCaster.cast(expelliarmus, "The opponent is disarmed by%s"::formatted);
    }
}
