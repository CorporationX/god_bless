package school.faang.hogwarts.spell.management;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spellsSystem = new HogwartsSpells();

        spellsSystem.printAllSpellEvents();

        spellsSystem.addSpellEvent("Чар", "Заставляет предмет летать");
        spellsSystem.addSpellEvent("Защита", "Блокирует удар");
        spellsSystem.addSpellEvent("Трансфигурация", "Превращает предмет");
        spellsSystem.addSpellEvent("Трансфигурация", "Превращает человека");
        spellsSystem.addSpellEvent("Чар", "Открывает замки");

        spellsSystem.printAllSpellEvents();

        System.out.println("\nПоиск заклинания с ID 2:");
        spellsSystem.getSpellEventById(2).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Не найдено")
        );

        System.out.println("\nВсе трансфигурации:");
        spellsSystem.getSpellEventsByType("Трансфигурация").forEach(System.out::println);

        spellsSystem.deleteSpellEvent(1);
        spellsSystem.deleteSpellEvent(13);
        System.out.println("\nПоиск заклинания с ID 1 после удаления:");
        spellsSystem.getSpellEventById(1).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Не найдено")
        );

        spellsSystem.printAllSpellEvents();
    }
}
