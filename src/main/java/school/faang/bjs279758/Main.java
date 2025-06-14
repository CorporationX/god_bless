package school.faang.bjs279758;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spellSystem = new HogwartsSpells();

        spellSystem.addSpellEvent("Чар", "Заставляет предметы парить в воздухе");
        spellSystem.addSpellEvent("Трансфигурация", "Превращает животное в чашку");
        spellSystem.addSpellEvent("Защита", "Создаёт щит против атак");
        spellSystem.addSpellEvent("Чар", "Открывает двери без ключа");

        System.out.println("\nПоиск заклинания по ID:");
        SpellEvent foundById = spellSystem.getSpellEventById(2);
        System.out.println(foundById != null ? foundById : "Заклинание не найдено");

        System.out.println("\nСписок заклинаний по типу 'Чар':");
        for (SpellEvent spell : spellSystem.getSpellEventsByType("Чар")) {
            System.out.println(spell);
        }

        System.out.println("\nУдаление заклинания с ID 1:");
        spellSystem.deleteSpellEvent(1);

        System.out.println("\nВсе оставшиеся заклинания:");
        spellSystem.printAllSpellEvents();

        System.out.println("\nПопытка удалить несуществующее заклинание (ID 99):");
        spellSystem.deleteSpellEvent(99);
    }
}
