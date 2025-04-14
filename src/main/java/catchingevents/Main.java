package catchingevents;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Чар", "Создаёт свет");
        spells.addSpellEvent("Защита", "Защищает от атак");
        spells.addSpellEvent("Трансфигурация", "Преобразует предмет");

        System.out.println("--- Все заклинания ---");
        spells.printAllSpellEvents();

        System.out.println("\n--- Заклинания по типу 'Защита' ---");
        List<SpellEvent> protectionSpells = spells.getSpellEventsByType("Защита");
        protectionSpells.forEach(System.out::println);

        System.out.println("\n--- Удаление заклинания по ID 0 ---");
        spells.deleteSpellEvent(0);
        spells.printAllSpellEvents();
    }
}
