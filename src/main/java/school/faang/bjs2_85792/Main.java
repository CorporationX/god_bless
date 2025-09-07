package school.faang.bjs2_85792;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(EventType.Protection, "Protection from fire");
        hogwartsSpells.addSpellEvent(EventType.Protection, "Protection from water");
        hogwartsSpells.addSpellEvent(EventType.Protection, "Protection from Avada kedavra");
        hogwartsSpells.addSpellEvent(EventType.Protection, "Protection from air");

        hogwartsSpells.addSpellEvent(EventType.Enchantment, "Tree Attack");
        hogwartsSpells.addSpellEvent(EventType.Enchantment, "House attack");
        hogwartsSpells.addSpellEvent(EventType.Transfiguration, "Attack on the store");
        hogwartsSpells.addSpellEvent(EventType.Transfiguration, "Fire Attack");

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(3);

        hogwartsSpells.printAllSpellEvents();

    }
}
