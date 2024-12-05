package school.faang.sprint1.bjs_44580;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        HashMap<String, List<SpellEvent>> result = hogwartsSpells.getSpellByType();

        // тестирование методов addSpellEvent, printAllSpellEvents
        hogwartsSpells.addSpellEvent(0, "Чар", "Защищает от атак");
        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.addSpellEvent(1, "Чар", "Атакующее");
        hogwartsSpells.printAllSpellEvents();

        // тестирование метода getSpellEventById
        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(0);
        System.out.println(spellEvent.getEventType());

        // тестирование методов getSpellEventByType, deleteSpellEvent
        hogwartsSpells.addSpellEvent(2, "Защита", "Воздушный барьер");
        List<SpellEvent> spellEventList = hogwartsSpells.getSpellEventByType("Чар");
        printListId(spellEventList);
        spellEventList = hogwartsSpells.getSpellEventByType("Защита");
        printListId(spellEventList);
        hogwartsSpells.deleteSpellEvent(0);
        hogwartsSpells.printAllSpellEvents();
    }

    public static void printListId(List<SpellEvent> spellEventList) {
        for (SpellEvent spellEvent : spellEventList) {
            System.out.println(spellEvent.getId());
        }
        System.out.println("--------------");
    }
}
