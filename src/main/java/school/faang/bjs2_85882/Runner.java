package school.faang.bjs2_85882;

public class Runner {
    public static void main(String[] args) {

        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Charm", "Lumos");
        spells.addSpellEvent("Charm", "Alohomora");
        spells.addSpellEvent("Curse", "Crucio");
        spells.addSpellEvent("Hex", "Bat-Bogey Hex");

        System.out.println("Заклинание с ID 2:");
        System.out.println(spells.getSpellEventById(2)); // Crucio

        System.out.println("\nВсе заклинания типа 'Charm':");
        for (SpellEvent e : spells.getSpellEventsByType("Charm")) {
            System.out.println(e);
        }

        System.out.println("\nУдаляем заклинание с ID 1...");
        spells.deleteSpellEvent(1); // Alohomora

        System.out.println("\nЗаклинания типа 'Charm' после удаления:");
        for (SpellEvent e : spells.getSpellEventsByType("Charm")) {
            System.out.println(e);
        }

        System.out.println("\nВсе оставшиеся заклинания:");
        spells.printAllSpellEvents();
    }
}
