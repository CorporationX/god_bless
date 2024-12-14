package school.faang.sprint1.task44660lovim;

import static school.faang.sprint1.task44660lovim.HogwartsSpells.*;
import static school.faang.sprint1.task44660lovim.HogwartsSpells.getSpellEventsByType;

public class Main {
    public static void main(String[] args) {
        addSpellEvent(1, "Защита", "Защищает от атак");
        addSpellEvent(2, "Трансфигурация", "Преобразует предмет");
        addSpellEvent(3, "Чар", "Кастует фаербол");
        addSpellEvent(4, "Защита", "Защищает от яда");

        System.out.println(getSpellEventById(1));
        System.out.println(getSpellEventsByType("Защита"));

        System.out.println("Защита:");
        for (var spellEvent : getSpellEventsByType("Защита")) {
            System.out.printf("id: %d | action: %s%n", spellEvent.getId(),
                    spellEvent.getAction());
        }

        deleteSpellEvent(3);
        deleteSpellEvent(5);

        printAllSpellEvents();
    }
}
