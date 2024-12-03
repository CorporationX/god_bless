package school.faang.task_44473;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        SpellEvent event = new SpellEvent(0, EventType.Enchantment, "Enchant an stuff to deal more damage!");
        SpellEvent event2 = new SpellEvent(1, EventType.Enchantment, "Enchant an stuff to have more stamina!!");
        SpellEvent event3 = new SpellEvent(2, EventType.Protection, "Enchant an stuff to be more safe!");

        hogwartsSpells.addSpellEvent(event.getId(), event.getEventType().toString(), event.getAction());
        hogwartsSpells.addSpellEvent(event2.getId(), event2.getEventType().toString(), event2.getAction());
        hogwartsSpells.addSpellEvent(event3.getId(), event3.getEventType().toString(), event3.getAction());

        System.out.println(hogwartsSpells.getSpellEventById(event2.getId()));
        System.out.println(hogwartsSpells.getSpellEventsByType(EventType.Enchantment.toString()));
        hogwartsSpells.deleteSpellEvent(event2.getId());

        hogwartsSpells.printAllSpellEvents();
    }
}
