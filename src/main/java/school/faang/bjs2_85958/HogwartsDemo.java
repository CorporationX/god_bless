package school.faang.bjs2_85958;

public class HogwartsDemo {
    public static void main(String[] args) {
        HogwartsSpells hogwarts = new HogwartsSpells();
        hogwarts.addSpellEvent("Защита", "Щит от атак");
        hogwarts.addSpellEvent("Чары", "Левитация пера");
        hogwarts.addSpellEvent("Трансфигурация", "Превращение чашки в мышь");

        System.out.println("Все заклинания:");
        hogwarts.printAllSpellEvents();

        System.out.println("Поиск по ID: " + hogwarts.getSpellEventById(3));
        System.out.println("Защита: " + hogwarts.getSpellEventsByType("Защита"));
        System.out.println("Удалить ID: " + hogwarts.deleteSpellEvent(2));
        System.out.println("После удаления:");
        hogwarts.printAllSpellEvents();
    }
}
