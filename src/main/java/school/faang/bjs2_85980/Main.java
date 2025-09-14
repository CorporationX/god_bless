package school.faang.bjs2_85980;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Чар", "Заставляет предмет летать");
        hogwartsSpells.addSpellEvent("Защита", "Создает защитный барьер");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Превращает один предмет в другой");
        hogwartsSpells.addSpellEvent("Чар", "Вызывает свет на конце палочки");
        hogwartsSpells.addSpellEvent("Защита", "Отражает заклинания противника");
        hogwartsSpells.addSpellEvent("Исцеление", "Лечит раны и болезни");

        System.out.println("All spells:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\nGet spell by ID:");
        System.out.println(hogwartsSpells.getSpellEventById(2));

        System.out.println("\nGet all 'Чар' spells:");
        System.out.println(hogwartsSpells.getSpellEventsByType("Чар"));

        System.out.println("\nDelete spell with ID 1");
        hogwartsSpells.deleteSpellEvent(1);

        System.out.println("\nAll spells after deletion:");
        hogwartsSpells.printAllSpellEvents();
    }
}