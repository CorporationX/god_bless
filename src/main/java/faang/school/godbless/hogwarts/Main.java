package faang.school.godbless.hogwarts;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        // Заклинание "Алохомора" (открывает дверь)
        spellCaster.cast("Alohomora", (spell) -> "The door is unlocked by " + spell);

        // Заклинание "Люмос" (создает свет)
        spellCaster.cast("Lumos", (spell) -> "A beam of light is created by " + spell);

        // Заклинание "Экспелиармус" (разоружает противника)
        spellCaster.cast("Expelliarmus", (spell) -> "The opponent is disarmed by " + spell);
    }
}