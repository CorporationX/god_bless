package school.faang.task_44692;

public class Main {
    public static void main(String[] args) {
        SpellEvent spell = new SpellEvent(1, "Чар", "Защищает от атак");
        HogwartsSpells.addSpellEvent(1, "Чар", "Защищает от атак");
        HogwartsSpells.prinAllSpellEvents();

        System.out.println(HogwartsSpells.getSpellEventsByType(spell.getEventType()));

    }
}
