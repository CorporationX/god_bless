package school.faang.task_44464;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "ENCHANTMENT", "Защищает от атак");
        hogwartsSpells.addSpellEvent(2, "TRANSFIGURATION", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(3, "TRANSFIGURATION", "Вакум");

        List<SpellEvent> transfiguration = hogwartsSpells.getSpellEventByType("ENCHANTMENT");
        System.out.println(transfiguration);
        hogwartsSpells.deleteSpellEvent(1);
        System.out.println(transfiguration);
        hogwartsSpells.printAllEvents();

    }
}
