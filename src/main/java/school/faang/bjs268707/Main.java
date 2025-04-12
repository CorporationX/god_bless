package school.faang.bjs268707;

public class Main {

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Expelliarmus", "Disarming Spell");
        hogwartsSpells.addSpellEvent("Lumos", "Light Spell");
        hogwartsSpells.addSpellEvent("Accio", "Summoning Charm");
        hogwartsSpells.addSpellEvent("Expecto Patronum", "Patronus Charm");
        hogwartsSpells.addSpellEvent("Avada Kedavra", "Killing Curse");

        hogwartsSpells.printAllSpellEvents();
        System.out.println("Spell event by id: " + hogwartsSpells.getSpellEventById(4));
        System.out.println("Spell events list by event type:" + hogwartsSpells.getSpellEventsByType("Avada Kedavra"));
        hogwartsSpells.deleteSpellEvent(3);
        hogwartsSpells.printAllSpellEvents();
    }
}
