package school.faang.bjs2_69898;

public class Main {
    public static void main(String [] args) {
        var spells = new HogwartsSpells();
        spells.addSpellEvent(EventType.Enchantment, "Огненное заклинание");
        spells.addSpellEvent(EventType.Protection, "Живой щит");
        spells.addSpellEvent(EventType.Transfiguration, "Трасмутация");

        spells.printAllSpellEvents();
        spells.getSpellEventsByType(EventType.Enchantment).forEach(System.out::println);

        System.out.println(spells.getSpellEventById(1));
        System.out.println(spells.getSpellEventById(2));

        spells.deleteSpellEvent(1);

        spells.printAllSpellEvents();
    }
}