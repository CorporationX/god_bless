package school.faang.task_44622;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent(1, "Сharm",
                "Lights up the tip of the wand");
        HogwartsSpells.addSpellEvent(2, "TRANSFIGURATION",
                "Transforms an object into another object");
        HogwartsSpells.addSpellEvent(3, "PROTECTION",
                "Creates a magical shield against attacks");
        HogwartsSpells.addSpellEvent(4, "Сharm",
                "Summons an item to the caster");
        HogwartsSpells.addSpellEvent(5, "TRANSFIGURATION",
                "Turns an animal into an object");
        HogwartsSpells.addSpellEvent(6, "PROTECTION",
                "Neutralizes an opponent's spells");
        HogwartsSpells.addSpellEvent(7, "Сharm",
                "Increases the volume of the voice");
        HogwartsSpells.addSpellEvent(8, "TRANSFIGURATION",
                "Creates a duplicate of an object");

        HogwartsSpells.printAllSpellEvents();
        System.out.println(HogwartsSpells.getSpellEventById(4));
        System.out.println(HogwartsSpells.getSpellEventsByType("PROTECTION"));
        HogwartsSpells.deleteSpellEvent(8);
        HogwartsSpells.printAllSpellEvents();
    }
}
