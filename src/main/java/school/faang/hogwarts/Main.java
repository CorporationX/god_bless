package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        final String alohomora = "Alohomora";
        final String lumos = "Lumos";
        final String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "Открытие Замков " + spell);
        spellCaster.cast(lumos, (spell) -> "Освещение пространства " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "Урон противнику " + spell);
    }
}
