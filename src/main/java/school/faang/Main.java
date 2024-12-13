package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(2, "Защита", "Защищает от атак");

        hogwartsSpells.printAllSpellEvents();

        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(1);
        System.out.println("SpellEvent by id: "
                + spellEvent.getId() + " "
                + spellEvent.getEventType() + " "
                + spellEvent.getAction());


        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType("Трансфигурация");

        System.out.println("SpellEvents by type: "
                + spellEvents.get(0).getId() + " "
                + spellEvents.get(0).getEventType() + " "
                + spellEvents.get(0).getAction());
        //Тут правильнее было бы проходить foreach и выводить каждый элемент списка

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
    }
}
