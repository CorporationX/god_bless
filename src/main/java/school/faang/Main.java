package school.faang;

import school.faang.cather.HogwartsSpells;
import school.faang.cather.SpellEvent;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Атака", "Кастует огненный шар");
        HogwartsSpells.addSpellEvent("Трансфигурация", "Превращает стекло в воду");
        HogwartsSpells.addSpellEvent("Защита", "Энергетическая сфера");
        HogwartsSpells.addSpellEvent("Защита", "Ледяной щит");

        System.out.println("Заклинание по айди: " + HogwartsSpells.getSpellEventById(2).getEventType() + "\n");

        List<SpellEvent> spellEvents = (HogwartsSpells.getSpellEventsByType("Защита"));
        System.out.print("Заклинание по типу: ");
        for (SpellEvent event : spellEvents) {
            System.out.print(event.getAction() + "\t");
        }
        System.out.println("\n");

        System.out.println("До удаления по id: ");
        HogwartsSpells.printAllSpellEvents();
        HogwartsSpells.deleteSpellEvent(2);
        System.out.println("После удаления по id: ");
        HogwartsSpells.printAllSpellEvents();
    }
}