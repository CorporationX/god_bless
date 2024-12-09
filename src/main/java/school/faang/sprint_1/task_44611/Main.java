package school.faang.sprint_1.task_44611;

public class Main {
    public static HogwartsSpells hogwartsSpells = new HogwartsSpells();

    public static void main(String[] args) {

        addSpellEvent(1, "Трансфигурация", "Преобразует предмет");
        addSpellEvent(2, "Защита", "Защита от атак");

        hogwartsSpells.printAllSpellEvents();

        addSpellEvent(3, "Левитация", "Поднимает предметы в воздух");

        hogwartsSpells.printAllSpellEvents();

        getSpellEventById(2);
        getSpellEventById(8);

        getSpellEventsByType("Левитация");
        getSpellEventsByType("Чары");

        addSpellEvent(4, "Защита", "Защита от чар");

        getSpellEventsByType("Защита");

        hogwartsSpells.printAllSpellEvents();

        deleteSpellEvent(7);
        deleteSpellEvent(3);

        hogwartsSpells.printAllSpellEvents();
    }

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        var spellEvent = hogwartsSpells.addSpellEvent(id, eventType, actionDescription);
        System.out.println("Добавлено новое заклинание " + spellEvent + "\n");
    }

    public static void getSpellEventById(int id) {
        var spellEvent = hogwartsSpells.getSpellEventById(id);
        if (spellEvent == null) {
            System.out.println("Заклинание по id=" + id + " не найдено\n");
        } else {
            System.out.println("Залклинание по id=" + id + ": " + spellEvent + "\n");
        }
    }

    public static void getSpellEventsByType(String evenType) {
        var spellEventsList = hogwartsSpells.getSpellEventsByType(evenType);
        if (spellEventsList == null) {
            System.out.println("Заклинания по типу " + evenType + " не найдены\n");
        } else {
            System.out.println("Заклинания по типу " + evenType + ":");
            for (var spellEvent : spellEventsList) {
                System.out.println(spellEvent);
            }
            System.out.println();
        }
    }

    public static void deleteSpellEvent(int id) {
        var deletedSpellEvent = hogwartsSpells.deleteSpellEvent(id);
        if (deletedSpellEvent == null) {
            System.out.println("Не найдено заклинание с id=" + id + "\n");
        } else {
            System.out.println("Удалено заклинание " + deletedSpellEvent + "\n");
        }
    }
}
