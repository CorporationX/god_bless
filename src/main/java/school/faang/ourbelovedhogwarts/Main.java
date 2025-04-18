package school.faang.ourbelovedhogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String myExample = "Лямбда-выражение с конкатенацией";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
        spellCaster.cast(myExample, (spell) -> "Эта строка была создана, когда функциональный интерфейс использовал "
                + spell + ", отличное от примеров задачи");
    }
}
