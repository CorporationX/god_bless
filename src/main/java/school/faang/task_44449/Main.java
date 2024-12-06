package school.faang.task_44449;

public class Main {
    public static void main(String[] args) {
        try {
            HogwartsSpells hogwartsSpells = new HogwartsSpells();

            hogwartsSpells.addSpellEvent(1, "Чар", "Левитация предметов");
            hogwartsSpells.addSpellEvent(2, "Трансфигурация", "Преобразует предмет");
            hogwartsSpells.addSpellEvent(3, "Защита", "Создает защитный барьер");
            hogwartsSpells.addSpellEvent(4, "Чар", "Открывает замки");

            System.out.println("Все заклинания в системе:");
            hogwartsSpells.printAllSpellEvents();

            System.out.println("\nПоиск заклинания по ID:");
            System.out.println(hogwartsSpells.getSpellEventById(2).getEventType());

            System.out.println("\nПоиск заклинаний по типу:");
            var spellEventList = hogwartsSpells.getSpellEventsByType("Чар");
            if (!spellEventList.isEmpty()) {
                for (var event : spellEventList) {
                    System.out.println(event.getEventType() + ": " + event.getAction());
                }
            }

            System.out.println("\nУдаление заклинания по ID:");
            hogwartsSpells.deleteSpellEvent(1);

            System.out.println("\nВсе заклинания в системе после удаления:");
            hogwartsSpells.printAllSpellEvents();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
