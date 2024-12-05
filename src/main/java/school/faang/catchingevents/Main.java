package school.faang.catchingevents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Cast", "Fireball");
        hogwartsSpells.addSpellEvent(2, "Interrupt", "Enemy spellcasting");
        hogwartsSpells.addSpellEvent(3, "Interrupt", "Enemy Test");
        hogwartsSpells.printAllSpellEvents();
        System.out.println("-----------------------------------------------------");
        System.out.println(hogwartsSpells.getSpellEventById(2).getAction());
        System.out.println("-----------------------------------------------------");
        hogwartsSpells.getSpellEventsByType("Interrupt")
                .forEach(spellEvent -> System.out.println(spellEvent.getAction()));
        System.out.println("-----------------------------------------------------");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
    }
}
