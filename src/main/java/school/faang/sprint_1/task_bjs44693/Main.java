package school.faang.sprint_1.task_bjs44693;

public class Main {
    public static void main(String[] args) {
        SpellEvent spellEvent = new SpellEvent(1, SpellType.ATTACK);
        SpellEvent spellEvent2 = new SpellEvent(2, SpellType.DEFENCE);
        SpellEvent spellEvent3 = new SpellEvent(3, SpellType.DEFENCE);

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(spellEvent);
        hogwartsSpells.addSpellEvent(spellEvent2);
        hogwartsSpells.addSpellEvent(spellEvent3);

        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println(hogwartsSpells.getSpellEventsByType(SpellType.ATTACK));

        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();

    }
}
