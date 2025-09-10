package school.faang.bjs2_87457;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("Alohomora", (spell) -> "Разблокирует дверь: " + spell);
        spellCaster.cast("Patronus", (spell) -> "Вызывает патронус: " + spell);
        spellCaster.cast("Expelliarmus", (spell) -> "Обезоруживает врага: " + spell);
    }
}
