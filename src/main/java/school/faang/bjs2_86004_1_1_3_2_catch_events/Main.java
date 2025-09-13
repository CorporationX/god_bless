package school.faang.bjs2_86004_1_1_3_2_catch_events;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Attack", "Expelliarmus");
        hogwartsSpells.addSpellEvent("Attack", "Stupefy");
        hogwartsSpells.addSpellEvent("Attack", "Avada Kedavra");
        hogwartsSpells.addSpellEvent("Defense", "Protego");
        hogwartsSpells.addSpellEvent("Utility", "Lumos");
        hogwartsSpells.addSpellEvent("Utility", "Nox");
        hogwartsSpells.addSpellEvent("Healing", "Episkey");
        hogwartsSpells.addSpellEvent("Defense", "Salvio Hexia");
        hogwartsSpells.addSpellEvent("Attack", "Petrificus Totalus");
        hogwartsSpells.addSpellEvent("Utility", "Accio");

        System.out.println("Все заклинания:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\nЗаклинание с ID 4:");
        System.out.println(hogwartsSpells.getSpellEventById(4).getAction());

        System.out.println("\nЗаклинания типа Attack:");
        for (SpellEvent s : hogwartsSpells.getSpellEventByType("Attack")) {
            System.out.println(s);
        }

        hogwartsSpells.deleteSpellEvent(2);
        System.out.println("\nПосле удаления ID 2:");
        hogwartsSpells.printAllSpellEvents();
    }
}
