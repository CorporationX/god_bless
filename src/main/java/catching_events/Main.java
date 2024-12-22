package catching_events;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Чары", "пить пиво без рук");
        hogwartsSpells.addSpellEvent(2,"Защита","протекто создал купол защиты");
        hogwartsSpells.getSpellEventsByType("Защита");
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.getSpellEventById(1);
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();

    }
}
