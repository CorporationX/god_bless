package school.faang.sprint_1.task_bjs44693;

public class Main {
    public static void main(String[] args) {
        SpellEvent spellEvent = new SpellEvent(1, SpellType.DEFENCE);
        SpellEvent spellEvent2 = new SpellEvent(2, SpellType.ATTACK);
        SpellEvent spellEvent3 = new SpellEvent(2, SpellType.DEFENCE);

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(spellEvent);
        hogwartsSpells.addSpellEvent(spellEvent2);
        hogwartsSpells.addSpellEvent(spellEvent3);
        System.out.println("=======BEFORE DELETE=======");
        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(4);
        System.out.println();
        System.out.println();
        System.out.println("=======AFTER DELETE=======");
        hogwartsSpells.printAllSpellEvents();
    }
}
