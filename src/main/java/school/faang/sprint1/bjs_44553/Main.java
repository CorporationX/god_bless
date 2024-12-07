package school.faang.sprint1.bjs_44553;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spellSystem = new HogwartsSpells();

        spellSystem.addSpellEvent(11, "Transfiguration", "Transforms an item");
        spellSystem.addSpellEvent(28, "Protection", "Protects from attacks");
        spellSystem.printAllSpellEvents();
        System.out.println("---------------------");
        SpellEvent searchEvent = spellSystem.getSpellEventById(28);
        System.out.println(searchEvent);
        System.out.println("---------------------");
        List<SpellEvent> eventsTypeList = spellSystem.getSpellEventsByType("Transfiguration");
        eventsTypeList.forEach(System.out::println);
        System.out.println("---------------------");
        spellSystem.deleteSpellEvent(11);
        spellSystem.printAllSpellEvents();
    }
}
