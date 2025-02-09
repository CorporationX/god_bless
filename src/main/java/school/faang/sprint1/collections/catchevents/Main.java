package school.faang.sprint1.collections.catchevents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чары", "Левитирует предмет");
        hogwartsSpells.addSpellEvent("Чары", "Осветляет кончик палочки");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует объект в животное");
        hogwartsSpells.addSpellEvent("Защита", "Создаёт магический барьер");

        System.out.println("Список заклинаний:");
        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println("Получение заклинания по ID = 1:");
        try {
            System.out.println(hogwartsSpells.getSpellEventById(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Заклинания типа 'Чары':");
        try {
            System.out.println(hogwartsSpells.getSpellEventsByType("Чары"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Удаление заклинания с ID = 2");
        try {
            hogwartsSpells.deleteSpellEvent(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Список заклинаний после удаления:");
        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println("Попытка получить несуществующее заклинание:");
        try {
            System.out.println(hogwartsSpells.getSpellEventById(99));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Попытка получить заклинания несуществующего типа:");
        try {
            System.out.println(hogwartsSpells.getSpellEventsByType("Люмос"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
