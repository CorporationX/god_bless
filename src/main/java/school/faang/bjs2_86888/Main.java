package school.faang.bjs2_86888;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Добро пожаловать в систему управления заклинаниями Хогвартса! ===\n");

        HogwartsSpells spellSystem = new HogwartsSpells();

        System.out.println("1. Добавление заклинаний в систему:\n");
        spellSystem.addSpellEvent("Чар", "Левитирует предметы в воздухе");
        spellSystem.addSpellEvent("Трансфигурация", "Превращает спички в иголки");
        spellSystem.addSpellEvent("Защита", "Создает защитный барьер от темных искусств");
        spellSystem.addSpellEvent("Чар", "Освещает темноту ярким светом");
        spellSystem.addSpellEvent("Трансфигурация", "Превращает животных в предметы");
        spellSystem.addSpellEvent("Зелья", "Варит лечебное зелье");

        System.out.println("2. Все заклинания в системе:");
        System.out.println("─".repeat(50));
        spellSystem.printAllSpellEvents();
        System.out.println("─".repeat(50) + "\n");

        System.out.println("3. Поиск заклинаний по ID:");
        int searchId = 3;
        SpellEvent foundSpell = spellSystem.getSpellEventById(searchId);
        if (foundSpell != null) {
            System.out.printf("Заклинание с ID %d найдено: %s%n", searchId, foundSpell);
        } else {
            System.out.printf("Заклинание с ID %d не найдено%n", searchId);
        }

        System.out.println("4. Поиск заклинаний по типу:");
        String searchType = "Чар";
        List<SpellEvent> charmSpells = spellSystem.getSpellEventsByType(searchType);
        System.out.printf("Заклинания типа '%s':%n", searchType);
        if (charmSpells != null && !charmSpells.isEmpty()) {
            for (SpellEvent spell : charmSpells) {
                System.out.printf("  - ID: %d, Действие: %s%n", spell.getId(), spell.getAction());
            }
        } else {
            System.out.printf("Заклинания типа '%s' не найдены%n", searchType);
        }

        System.out.println("5. Удаление заклинания:");
        int deleteId = 2;
        spellSystem.deleteSpellEvent(deleteId);

        SpellEvent deletedSpell = spellSystem.getSpellEventById(deleteId);
        if (deletedSpell == null) {
            System.out.printf("Заклинание с ID %d успешно удалено%n", deleteId);
        }
        System.out.println();


        System.out.println("6. Состояние системы после удаления:");
        System.out.println("─".repeat(50));
        spellSystem.printAllSpellEvents();
        System.out.println("─".repeat(50) + "\n");
    }
}