package school.faang.catch_events;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, EventType.TRANSFIGURATION, "turn into dragon");
        hogwartsSpells.addSpellEvent(2, EventType.TRANSFIGURATION, "turn into mouse");
        hogwartsSpells.addSpellEvent(3, EventType.TRANSFIGURATION, "turn into stone");
        hogwartsSpells.addSpellEvent(4, EventType.SAFE, "make a fire wall");
        hogwartsSpells.addSpellEvent(5, EventType.SAFE, "become invisible");
        hogwartsSpells.addSpellEvent(6, EventType.BEWITCH, "make fall asleep");
        hogwartsSpells.addSpellEvent(7, EventType.BEWITCH, "make blind");

        try {
            System.out.println(hogwartsSpells.getSpellEventById(4));
            System.out.println(hogwartsSpells.getSpellEventById(40));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(hogwartsSpells.getSpellEventsByType("SAFE"));
            System.out.println(hogwartsSpells.getSpellEventsByType("Something else"));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        try {
            hogwartsSpells.deleteSpellEvent(2);
            hogwartsSpells.deleteSpellEvent(23);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
            hogwartsSpells.printAllSpellEvents();

    }
}
