package school.faang.bjs2_69898;

public class Main {
    public static void main(String [] args) {
        var spells = new HogwartsSpells();

        spells.addSpellEvent("Чар", "Огненное заклинание");
        spells.addSpellEvent("Защита", "Живой щит");
        spells.addSpellEvent("Трансфигурация", "Трасмутация");

        spells.printAllSpellEvents();

        for (var event : spells.getSpellEventsByType("Чар")) {
            System.out.println(event);
        }

        System.out.println(spells.getSpellEventById(1));
        System.out.println(spells.getSpellEventById(2));

        spells.deleteSpellEvent(1);

        spells.printAllSpellEvents();
    }
}