package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("abra-ka-da-bra", (spell) -> spell + " применено!");
    }
}
