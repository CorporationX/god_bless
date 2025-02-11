package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(String.valueOf((Spells.ALOHOMORA)), (spell) -> "Открытие Замков " + spell);
        spellCaster.cast(String.valueOf((Spells.LUMOS)), (spell) -> "Освещение пространства " + spell);
        spellCaster.cast(String.valueOf((Spells.EXPELLIARMUS)), (spell) -> "Урон противнику " + spell);
    }
}
