package school.faang.catchingevent;

public class App {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        // Добавление заклинаний
        hogwartsSpells.addSpellEvent("Чар", "Левитирует объект");
        hogwartsSpells.addSpellEvent("Защита", "Создает магический барьер");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет в животное");

        System.out.println();

        // Получение заклинания по ID
        hogwartsSpells.getSpellEventById(1);

        System.out.println();

        // Получение заклинаний по типу
        hogwartsSpells.getSpellEventsByType("Защита");

        System.out.println();

        // Удаление заклинания
        hogwartsSpells.deleteSpellEvent(2);

        System.out.println();

        // Получение заклинаний по типу после удаления
        hogwartsSpells.getSpellEventsByType("Защита");

        System.out.println();

        // Печать всех заклинаний
        hogwartsSpells.printAllSpellEvents();
    }
}
