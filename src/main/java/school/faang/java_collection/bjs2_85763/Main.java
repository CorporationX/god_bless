package school.faang.java_collection.bjs2_85763;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Трансфигурация", "превращает один предмет в другой");
        hogwartsSpells.addSpellEvent("Защита", "защищает от атак");
        hogwartsSpells.addSpellEvent("Защита", "защищает от атак2");
        hogwartsSpells.addSpellEvent("Атака", "атакующие чары");
        hogwartsSpells.addSpellEvent("Атака", "атакующие чары2");
        hogwartsSpells.addSpellEvent("Атака", "атакующие чары3");

        int findBookFromId = 2;
        System.out.println("Поиск по id " + findBookFromId + ": " + hogwartsSpells.getSpellEventById(findBookFromId));

        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType("Атака");
        System.out.println(spellEvents);

        hogwartsSpells.deleteSpellEvent(5);

        hogwartsSpells.printAllSpellEvents();
    }
}