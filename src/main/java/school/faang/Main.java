package school.faang;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String accio = "Accio";
        String lumos = "Lumos";
        String aparecium = "Aparecium";

        spellCaster.cast(accio, (spell) -> "The object is attracted by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(aparecium, (spell) -> "The secret message is revealed by " + spell);
    }
}
