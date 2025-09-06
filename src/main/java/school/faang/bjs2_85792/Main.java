package school.faang.bjs2_85792;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Defence", "Protection from fire");
        hogwartsSpells.addSpellEvent("Defence", "Protection from water");
        hogwartsSpells.addSpellEvent("Defence", "Protection from Avada kedavra");
        hogwartsSpells.addSpellEvent("Defence", "Protection from air");

        hogwartsSpells.addSpellEvent("attack", "Tree Attack");
        hogwartsSpells.addSpellEvent("attack", "House attack");
        hogwartsSpells.addSpellEvent("attack", "Attack on the store");
        hogwartsSpells.addSpellEvent("attack", "Fire Attack");

        hogwartsSpells.deleteSpellEvent(3);
    }
}
