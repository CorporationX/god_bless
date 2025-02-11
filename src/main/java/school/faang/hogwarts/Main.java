package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String lumos = "Lumos";
        String fairball = "Fairball";
        spellCaster.cast(lumos, spell -> spell + " is used");
        spellCaster.cast(fairball, spell -> spell + " is used");
    }
}
