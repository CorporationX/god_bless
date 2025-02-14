package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Экспеллиармус", "Обеззаруживание");
        hogwartsSpells.addSpellEvent("Protego", "Отражение");
        hogwartsSpells.addSpellEvent("Люмус", "Фонарик");

        SpellEvent event = hogwartsSpells.getSpellEventById(2);
        System.out.println(event);

        List<SpellEvent> charm = hogwartsSpells.getSpellEventsByType("Люмус");
        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(1);

        hogwartsSpells.printAllSpellEvents();
    }
}