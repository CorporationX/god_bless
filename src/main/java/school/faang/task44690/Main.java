package school.faang.task44690;

import school.faang.task44690.service.HogwartsSpells;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells spells = getHogwartsSpells();

        spells.printAllSpellEvents();

        System.out.println("Заклинание 1:" + spells.getSpellEventById(1));
        System.out.println("Заклинание 3:" + spells.getSpellEventById(3));
        System.out.println("Заклинание 5:" + spells.getSpellEventById(5));

        System.out.println("Все заклинания с типом Defence:");
        System.out.println(spells.getSpellEventsByType("Defence"));
        System.out.println("Все заклинания с типом Charms:");
        System.out.println(spells.getSpellEventsByType("Charms"));

        spells.deleteSpellEvent(1);
        spells.deleteSpellEvent(2);
        spells.deleteSpellEvent(5);

        spells.printAllSpellEvents();

    }

    private static HogwartsSpells getHogwartsSpells() {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent(1, "Charms", "Очаровывает противника");
        spells.addSpellEvent(2, "Defence", "Защищает носителя");
        spells.addSpellEvent(3, "Damage", "Наносит урон");
        spells.addSpellEvent(4, "Transformation", "Превращает в мышь");
        spells.addSpellEvent(5, "Invisible", "Делает невидимым");
        spells.addSpellEvent(6, "Charms", "Усыпляет противника");
        spells.addSpellEvent(7, "Charms", "Ослепляет противника");
        return spells;
    }
}
