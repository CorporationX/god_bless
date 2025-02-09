package school.faang.bjs2_57222;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        System.out.println("Добавим события заклинаний и выведем их в консоль:");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Чар", "Делает противника недвижимым");

        hogwartsSpells.printAllSpellEvents();

        System.out.println("\n" + "Получим заклинание по его id:");
        System.out.println(hogwartsSpells.getSpellEventById(0));
        System.out.println("\n" + "Получим список заклинаний по типу заклинания:");
        System.out.println(hogwartsSpells.getSpellEventsByType("Чар"));

        System.out.println("\n" + "Удалим заклинание по его id:");
        hogwartsSpells.deleteSpellEvent(1);

        hogwartsSpells.printAllSpellEvents();
    }
}
