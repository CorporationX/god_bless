package school.faang.sprint_1.taskbjs244629;

public class Main {
    public static void main(String[] args) {
        final HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent(1, SpellEventType.DEFENSE);
        spells.addSpellEvent(2, SpellEventType.LEVIOSA);
        spells.addSpellEvent(3, SpellEventType.TRANSFIGURATION);
        spells.printAllSpellEvents();

        System.out.println(spells.getSpellEventById(2));
        System.out.println(spells.getSpellEventsByType(SpellEventType.DEFENSE));

        spells.deleteSpellEvent(2);
        spells.printAllSpellEvents();
    }
}
