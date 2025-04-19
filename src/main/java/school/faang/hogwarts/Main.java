package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (cast) -> "The door is unlocked by %s".formatted(cast));
        spellCaster.cast(lumos, (cast) -> "A beam of light is created by %s".formatted(cast));
        spellCaster.cast(expelliarmus, (cast) -> cast + " - " + cast);
    }
}
