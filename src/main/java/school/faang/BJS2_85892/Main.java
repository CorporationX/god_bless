package school.faang.BJS2_85892;

public class Main {

    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Charm", "Charms person or animal to temporarily fight at caster's side");
        hogwartsSpells.addSpellEvent("Enchantment", "Enchants target weapon with fire");
        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms target into a mouse");
        hogwartsSpells.addSpellEvent("Enchantment", "Enchants target weapon a lightning");


        SpellEvent searchedSpellEvent = hogwartsSpells.getSpellEventById(3);

        System.out.printf("%d => %s => %s%n",
                searchedSpellEvent.getId(),
                searchedSpellEvent.getEventType(),
                searchedSpellEvent.getAction());
        System.out.println("========================");

        for (SpellEvent se : hogwartsSpells.getSpellEventsByType("Enchantment")) {
            System.out.printf("%s => %s%n", se.getEventType(), se.getAction());
        }
        System.out.println("========================");

        hogwartsSpells.deleteSpellEvent(1);

        hogwartsSpells.printAllSpellEvents();
    }
}