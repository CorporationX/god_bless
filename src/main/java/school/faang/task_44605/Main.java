package school.faang.task_44605;

public class Main {
    public static void main(String[] args) {
        SpellEvent curseEvent = new SpellEvent(12, Type.CURSE);
        SpellEvent healEvent = new SpellEvent(14, Type.HEAL);
        SpellEvent transfigurationEvent = new SpellEvent(20, Type.TRANSFIGURATION);
        SpellEvent secondCurseEvent = new SpellEvent(21, Type.CURSE);

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(curseEvent);
        hogwartsSpells.addSpellEvent(healEvent);
        hogwartsSpells.addSpellEvent(transfigurationEvent);
        hogwartsSpells.addSpellEvent(secondCurseEvent);

        hogwartsSpells.deleteSpellEvent(20);

        hogwartsSpells.getSpellEventById(14);

        hogwartsSpells.getSpellEventsByType(Type.CURSE);

        hogwartsSpells.printAllSpellEvents();
    }
}
