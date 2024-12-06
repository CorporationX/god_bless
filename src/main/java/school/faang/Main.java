package school.faang;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent(2, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(3, "Защита", "Создает магический щит");
        hogwartsSpells.addSpellEvent(4, "Чар", "Усиливает магическую силу");

        hogwartsSpells.printAllSpellEvents();

        System.out.println("Заклинание с ID 2: " + hogwartsSpells.getSpellEventById(2));

        System.out.println("Все заклинания типа 'Чар': " + hogwartsSpells.getSpellEventsByType("Чар"));

        hogwartsSpells.deleteSpellEvent(3);

        hogwartsSpells.printAllSpellEvents();
    }
}
