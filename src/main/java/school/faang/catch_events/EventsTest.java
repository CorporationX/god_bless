package school.faang.catch_events;

import java.util.List;

public class EventsTest {
    public static void main(String[] args) {
        HogwartsSpells hogwarts = new HogwartsSpells();

        hogwarts.addSpellEvent("Transfiguration", "Change Object");
        hogwarts.addSpellEvent("Char", "Char Object");
        hogwarts.addSpellEvent("Defend", "Defend from attack");

        List<SpellEvent> events = hogwarts.getSpellEventsByType("Char");

        System.out.println(hogwarts.getSpellEventById(events.get(0).getId()));

        delimiter();

        System.out.println(events);

        delimiter();

        hogwarts.printAllSpellEvents();

        delimiter();

        hogwarts.deleteSpellEvent(events.get(0).getId());

        hogwarts.printAllSpellEvents();
    }

    private static void delimiter() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
    }
}
