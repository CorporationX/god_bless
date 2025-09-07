package school.faang.bjs2_85864;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Чары", "Защищает от атак");
        spells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        spells.addSpellEvent("Защита", "Создаёт магический барьер");
        spells.addSpellEvent("Чары", "Увеличивает силу удара");

        System.out.println("Все события:");
        spells.printAllSpellEvents();

        System.out.println("\nСобытие с ID = 2:");
        System.out.println(spells.getSpellEventById(2));

        System.out.println("\nСобытия типа 'Чары':");
        for (SpellEvent event : spells.getSpellEventByType("Чары")) {
            System.out.println(event);
        }

        System.out.println("\nУдаляем событие с ID = 3:");
        spells.deleteSpellEvent(3);

        System.out.println("\nВсе события после удаления:");
        spells.printAllSpellEvents();
    }
}
