package school.faang.cathing_events_bjs2_79681;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hs = new HogwartsSpells();
        hs.addSpellEvent("Огонь", "Фаербол");
        hs.addSpellEvent("Огонь", "Выжигание");
        hs.getSpellEventById(0);

        hs.getSpellEventsByType("Огонь");

        hs.deleteSpellEvent(0);

        hs.getSpellEventsByType("Огонь");

        hs.printAllSpellEvents();
    }
}
