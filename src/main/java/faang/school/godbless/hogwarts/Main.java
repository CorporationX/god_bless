package faang.school.godbless.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        spellCaster.cast(alohomora,(s)->"Action is "+s);
        spellCaster.cast(lumos,(s)->"Action is "+s);
        spellCaster.cast(expelliarmus,(s)->"Action is "+s);
    }
}
