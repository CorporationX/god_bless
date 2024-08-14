package faang.school.godbless.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (s) -> "The spell is " + s);
        spellCaster.cast(lumos, (s) -> "Another spell is " + s);
        spellCaster.cast(expelliarmus, (s) -> "The last spell could be " + s);
    }
}
