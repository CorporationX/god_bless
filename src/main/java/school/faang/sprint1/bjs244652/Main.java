package school.faang.sprint1.bjs244652;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();
        spells.addSpellEvent(1, "Защита", "защищает от неожиданных атак");
        spells.addSpellEvent(2, "Трансфигурация", "меняет образ испытуемого");
        spells.addSpellEvent(3, "Защита", "защищает от неожиданных атак");
        spells.addSpellEvent(4, "Чары", "замораживает противника на 10 секунд");

        int idForGetSpellEvent = 2;
        SpellEvent spellEventById = spells.getSpellEventById(idForGetSpellEvent);
        System.out.println("\nНашлось событие с " + spellEventById + ".");

        String type = "Защита";
        List<SpellEvent> spellEventsByType = spells.getSpellEventsType(type);
        System.out.println("\nСписок событий с типом заклинаний '" + type + "':\n" + spellEventsByType);

        int idForDelete = 3;
        spells.deleteSpellEvent(idForDelete);

        spells.printAllSpellEvents();
    }
}

