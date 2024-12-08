package school.faang.task44690;

import school.faang.task44690.model.EventType;
import school.faang.task44690.service.HogwartsSpells;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells spells = getHogwartsSpells();

        spells.printAllSpellEvents();

        System.out.println("Заклинание 1:" + spells.getSpellEventById(1));
        System.out.println("Заклинание 3:" + spells.getSpellEventById(3));
        System.out.println("Заклинание 5:" + spells.getSpellEventById(5));

        System.out.println("Все заклинания с типом Defence:");
        System.out.println(spells.getSpellEventsByType(EventType.DEFENCE));
        System.out.println("Все заклинания с типом Charms:");
        System.out.println(spells.getSpellEventsByType(EventType.CHARMS));

        spells.deleteSpellEvent(1);
        spells.deleteSpellEvent(2);
        spells.deleteSpellEvent(5);

        spells.printAllSpellEvents();
    }

    private static HogwartsSpells getHogwartsSpells() {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent(1, EventType.CHARMS, "Очаровывает противника");
        spells.addSpellEvent(2, EventType.DEFENCE, "Защищает носителя");
        spells.addSpellEvent(3, EventType.DAMAGE, "Наносит урон");
        spells.addSpellEvent(4, EventType.TRANSFORMATION, "Превращает в мышь");
        spells.addSpellEvent(5, EventType.INVISIBLE, "Делает невидимым");
        spells.addSpellEvent(6, EventType.CHARMS, "Усыпляет противника");
        spells.addSpellEvent(7, EventType.CHARMS, "Ослепляет противника");
        return spells;
    }
}
