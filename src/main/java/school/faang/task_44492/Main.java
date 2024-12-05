package school.faang.task_44492;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent(1, "Защита", "Защищает от атак");
        HogwartsSpells.addSpellEvent(2, "Чар", "Преобразует предмет");
        HogwartsSpells.addSpellEvent(3, "Трансфигурация", "Превращение стула в собаку");
        HogwartsSpells.addSpellEvent(4, "Зельеварение", "Превращение во что-то");
        HogwartsSpells.addSpellEvent(5, "Зельеварение", "Превращение лису");

        HogwartsSpells.printAllSpellEvents();

        System.out.println("--------------------------------------------------------------------------");

        SpellEvent spellEvent = HogwartsSpells.getSpellEventById(1);
        System.out.println(spellEvent.toString());

        System.out.println("--------------------------------------------------------------------------");

        List<SpellEvent> spellEventList = HogwartsSpells.getSpellEventsByType("Зельеварение");
        System.out.println(spellEventList);

        System.out.println("--------------------------------------------------------------------------");

        HogwartsSpells.deleteSpellEvent(4);
        HogwartsSpells.printAllSpellEvents();


    }
}
