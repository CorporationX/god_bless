package task_BJS2_57002;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Трансфигурация", "преобразует предмет");
        hogwartsSpells.addSpellEvent("Трансфигурация", "преобразует 2 предмета за раз");
        hogwartsSpells.addSpellEvent("Абракадабра", "что-то делает");

        Map<Integer, SpellEvent> spellById = hogwartsSpells.spellById;
        Map<String, List<SpellEvent>> spellsByType = hogwartsSpells.spellsByType;

        System.out.println(spellById);
        System.out.println(spellsByType);
        System.out.println();

        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println(hogwartsSpells.getSpellEventsByType("Трансфигурация"));
        System.out.println();

        hogwartsSpells.deleteSpellEvent(0);
        hogwartsSpells.printAllSpellEvents();
        System.out.println();


        HogwartsSpells hogwartsSpells2 = new HogwartsSpells();
        hogwartsSpells2.addSpellEvent("Тест", "что-то делает");
        Map<Integer, SpellEvent> spellById2 = hogwartsSpells2.spellById;
        Map<String, List<SpellEvent>> spellsByType2 = hogwartsSpells2.spellsByType;
        System.out.println(spellById2);
        System.out.println(spellsByType2);
        System.out.println();
        hogwartsSpells2.deleteSpellEvent(0);
        hogwartsSpells2.printAllSpellEvents();

    }
}
