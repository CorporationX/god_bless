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

        spellCaster.cast(alohomora, spell -> String.format("The door is unlocked by %s", spell));
        spellCaster.cast(lumos, spell -> String.format("A beam of light is created by %s", spell));
        spellCaster.cast(expilliarmus, spell -> String.format("The opponent is disarmed by %s", spell));
    }
}