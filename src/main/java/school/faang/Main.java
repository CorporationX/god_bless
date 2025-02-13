package school.faang;

public class Main {
    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();

        String avadaKedavra = "avadaKedavra";
        String protego = "protego";

        spellCaster.cast(avadaKedavra, (spell) -> "Death spell " + spell);
        spellCaster.cast(protego, (spell) -> "Reflection spell " + spell);
    }
}
