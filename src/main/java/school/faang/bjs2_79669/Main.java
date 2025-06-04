package school.faang.bjs2_79669;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Защита", "Защита от атак");
        hogwartsSpells.addSpellEvent("Атака", "Наносит урон копьем");
        hogwartsSpells.addSpellEvent("Атака", "Наносит урон мечом");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");

        hogwartsSpells.printAllSpellEvents();
        System.out.println("----------------------");
        System.out.println(hogwartsSpells.getSpellEventById(1L));
        System.out.println("----------------------");

        System.out.println(hogwartsSpells.getSpellEventByType("Атака"));
        System.out.println("----------------------");

        hogwartsSpells.deleteSpellEvent(1L);
        hogwartsSpells.printAllSpellEvents();

    }
}
