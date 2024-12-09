package school.faang.task_44575;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Чар", "Что-то делает");
        hogwartsSpells.addSpellEvent(2, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(3, "Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent(4, "Защита", "Защищает от атак от всего");

        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(4));
        System.out.println(hogwartsSpells.getSpellEventsByType("Трансфигурация"));
        System.out.println(hogwartsSpells.getSpellEventsByType("Защита"));
    }
}
