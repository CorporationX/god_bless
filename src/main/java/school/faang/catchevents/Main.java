package school.faang.catchevents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Zashita", "Zashishyaet ot atak");
        hogwartsSpells.addSpellEvent("Zashita", "Zashishyaet ot magii");
        hogwartsSpells.addSpellEvent("Ataka", "Atakuet opponenta");
        hogwartsSpells.addSpellEvent("Ataka", "Atakuet bossa");
        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventById(5));
        System.out.println(hogwartsSpells.getSpellEventsByType("Ataka"));
        System.out.println(hogwartsSpells.getSpellEventsByType("Atakssa"));
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
    }
}
