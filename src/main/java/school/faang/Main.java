package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent(1, "Защита", "защищает от неожиданных атак");
        HogwartsSpells.addSpellEvent(2, "Трансфигурация", "меняет образ испытуемого");
        HogwartsSpells.addSpellEvent(3, "Защита", "защищает от неожиданных атак");
        HogwartsSpells.addSpellEvent(4, "Чары", "замораживает противника на 10 секунд");

        int idForGetSpellEvent = 2;
        SpellEvent spellEventById = HogwartsSpells.getSpellEventById(idForGetSpellEvent);
        System.out.println("\nНашлось событие с " + spellEventById + ".");

        String type = "Защита";
        List<SpellEvent> spellEventsByType = HogwartsSpells.getSpellEventsType(type);
        System.out.println("\nСписок событий с типом заклинаний '" + type + "':\n" + spellEventsByType);

        int idForDelete = 3;
        HogwartsSpells.deleteSpellEvent(idForDelete);

        HogwartsSpells.printAllSpellEvents();
    }
}
