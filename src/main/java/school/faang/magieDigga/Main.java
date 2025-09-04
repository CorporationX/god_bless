package school.faang.magieDigga;


public class Main {
    public static void main(String[] args) {

        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Чар", "Создаёт магический эффект");
        spells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        spells.addSpellEvent("Защита", "Защищает от атак");
        spells.addSpellEvent("Чар", "Очаровывает противника");

        System.out.println("Все события:");
        spells.printAllSpellEvents();

        System.out.println("\nСобытия типа 'Чар':");
        spells.getSpellEventsByType("Чар").forEach(System.out::println);

        System.out.println("\nУдаляем событие с ID 2");
        spells.deleteSpellEvent(2);

        System.out.println("\nВсе события после удаления:");
        spells.printAllSpellEvents();

    }
}

