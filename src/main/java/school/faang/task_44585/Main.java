package school.faang.task_44585;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(new SpellEvent(13, SpellType.EXPECTO_PATRONUM));
        hogwartsSpells.addSpellEvent(new SpellEvent(14, SpellType.LUMOS));
        hogwartsSpells.addSpellEvent(new SpellEvent(15, SpellType.WINGARDIUM_LEVIOSA));

        System.out.println(hogwartsSpells.getSpellEventById(14));
        System.out.println(hogwartsSpells.getSpellEventsByType(SpellType.WINGARDIUM_LEVIOSA));

        hogwartsSpells.deleteSpellEvent(14);
        hogwartsSpells.printAllSpellEvents();
    }
}
