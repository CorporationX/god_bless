package school.faang.catch_events;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Transfiguration", "turn into dragon");
        hogwartsSpells.addSpellEvent(2, "Transfiguration", "turn into mouse");
        hogwartsSpells.addSpellEvent(3, "Transfiguration", "turn into stone");
        hogwartsSpells.addSpellEvent(4, "Safe", "make a fire wall");
        hogwartsSpells.addSpellEvent(5, "Safe", "become invisible");
        hogwartsSpells.addSpellEvent(6, "Bewitch", "make fall asleep");
        hogwartsSpells.addSpellEvent(7, "Bewitch", "make blind");

        System.out.println(hogwartsSpells.getSpellEventById(4));
        System.out.println(hogwartsSpells.getSpellEventById(40));
        System.out.println(hogwartsSpells.getSpellEventsByType("Safe"));
        System.out.println(hogwartsSpells.getSpellEventsByType("Something else"));
        hogwartsSpells.deleteSpellEvent(23);

    }
}
