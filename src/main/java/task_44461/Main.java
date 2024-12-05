package task_44461;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        addHogwartsSpells(hogwartsSpells);
        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventsByType("Защита").toString());
        hogwartsSpells.deleteSpellEvent(6);
    }

    private static void addHogwartsSpells(HogwartsSpells hogwartsSpells) {
        List<SpellEvent> spells = addSpells();

        for (SpellEvent spell : spells) {
            hogwartsSpells.addSpellEvent(spell.getId(), spell.getEventType(), spell.getAction());
        }
    }

    private static List<SpellEvent> addSpells() {
        List<SpellEvent> spells = new ArrayList<>();

        spells.add(new SpellEvent(1, "Чар", "Зачарование"));
        spells.add(new SpellEvent(2, "Трансфигурация", "Преобразует предмет"));
        spells.add(new SpellEvent(3, "Защита", "Защищает от атак"));
        spells.add(new SpellEvent(4, "Защита", "Защищает от магии"));
        spells.add(new SpellEvent(15, "Защита", "Защищает от оружия"));

        return spells;
    }
}