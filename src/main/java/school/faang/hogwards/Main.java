package school.faang.hogwards;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 * Дата: 16.09.2025
 * Описание: система для управления заклинаниями,
 * способна выполнять различные магические действия,
 * передавая эти действия в виде лямбда-выражений.
 */

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expilliarmus = "Expilliarmus";

        spellCaster.cast(alohomora, (spell -> "The door is unlocked by " + spell));
        spellCaster.cast(lumos, (spell -> "A beam of light is created by " + spell));
        spellCaster.cast(expilliarmus, (spell -> "The opponent is disarmed by " + spell));
    }
}