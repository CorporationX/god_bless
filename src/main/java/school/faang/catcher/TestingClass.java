package school.faang.catcher;

import java.util.List;

public class TestingClass {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Атака", "Кастует огненный шар");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Превращает стекло в воду");
        hogwartsSpells.addSpellEvent("Защита", "Энергетическая сфера");
        hogwartsSpells.addSpellEvent("Защита", "Ледяной щит");

        System.out.println("Заклинание по айди: " + hogwartsSpells.getSpellEventById(2).getEventType() + "\n");

        List<SpellEvent> spellEvents = (hogwartsSpells.getSpellEventsByType("Защита"));
        System.out.print("Заклинание по типу: ");
        for (SpellEvent event : spellEvents) {
            System.out.print(event.getAction() + "\t");
        }
        System.out.println("\n");

        System.out.println("До удаления по id: ");
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(2);
        System.out.println("После удаления по id: ");
        hogwartsSpells.printAllSpellEvents();
    }
}
