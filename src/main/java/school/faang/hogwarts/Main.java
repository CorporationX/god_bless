package school.faang.hogwarts;

public class Main {
    private static final String lumos = "Lumos";
    private static final String fairball = "Fairball";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(lumos, spell -> spell + " has been cast successfully");
        spellCaster.cast(fairball, spell -> spell + " has been cast successfully");
    }
}
