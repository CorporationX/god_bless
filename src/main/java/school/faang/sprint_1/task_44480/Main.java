package school.faang.sprint_1.task_44480;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spellsSystem = new HogwartsSpells();

        spellsSystem.addSpellEvent(1, "Чар", "Призывает огонь");
        spellsSystem.addSpellEvent(2, "Трансфигурация", "Преобразует предмет");
        spellsSystem.addSpellEvent(3, "Защита", "Создает щит");
        try {
            System.out.println("Заклинание id 1: " + spellsSystem.getSpellEventId(1));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Заклинания тип 'Защита': " + spellsSystem.getSpellEventsType("Защита"));

        spellsSystem.deleteSpellEvent(2);

        System.out.println("Все заклинания:");
        spellsSystem.printAll();
    }
}
