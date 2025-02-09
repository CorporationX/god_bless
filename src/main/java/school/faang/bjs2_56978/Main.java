package school.faang.bjs2_56978;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();
        spells.addSpellEvent("ABRACADABRA",
                "основное заклинание, которое используется, чтобы произвести магический эффект или изменение.");
        spells.addSpellEvent("RIDDIKULUS",
                "заклинание, которое превращает страшных созданий в смешные или нелепые формы.");
        spells.getSpellEventById(1);
        spells.getSpellEventsByType("ABRACADABRA");
        spells.deleteSpellEvent(1);
        spells.printAllSpellEvents();

    }
}
