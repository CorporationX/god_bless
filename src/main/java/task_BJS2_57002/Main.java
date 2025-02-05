package task_BJS2_57002;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Трансфигурация", "преобразует предмет");
        HogwartsSpells.addSpellEvent("Трансфигурация", "преобразует 2 предмета за раз");
        HogwartsSpells.addSpellEvent("Абракадабра", "что-то делает");

        Map<Integer, SpellEvent> spellById = HogwartsSpells.spellById;
        Map<String, List<SpellEvent>> spellsByType = HogwartsSpells.spellsByType;

        System.out.println(spellById);
        System.out.println(spellsByType);
        System.out.println();

        System.out.println(HogwartsSpells.getSpellEventById(2));
        System.out.println(HogwartsSpells.getSpellEventsByType("Трансфигурация"));
        System.out.println();

        HogwartsSpells.deleteSpellEvent(0);
        HogwartsSpells.printAllSpellEvents();


    }
}
