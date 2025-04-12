package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чар", "Бьёт по лицу");
        hogwartsSpells.addSpellEvent("Огонь", "Бьёт по торсу");
        hogwartsSpells.addSpellEvent("Вода", "Бьёт по ногам");
        hogwartsSpells.addSpellEvent("Крюк", "Бьёт по сам знаешь чему");

        hogwartsSpells.printAllSpellEvents();

        SpellEvent spellEventById = hogwartsSpells.getSpellEventById(1);
        System.out.println(spellEventById);

        List<SpellEvent> spellEventsByType = hogwartsSpells.getSpellEventsByType("Чар");
        System.out.println(spellEventsByType);

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
    }
}
