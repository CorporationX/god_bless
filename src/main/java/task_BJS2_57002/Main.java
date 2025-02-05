package task_BJS2_57002;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        Map<Integer, SpellEvent> spellById = HogwartsSpells.spellById;
        Map<String, List<SpellEvent>> spellsByType = HogwartsSpells.spellsByType;
        System.out.println(spellById);
        System.out.println(spellsByType);
        System.out.println();

        HogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует 2 предмета");
        Map<Integer, SpellEvent> spellById2 = HogwartsSpells.spellById;
        Map<String, List<SpellEvent>> spellsByType2 = HogwartsSpells.spellsByType;
        System.out.println(spellById2);
        System.out.println(spellsByType2);


    }
}
