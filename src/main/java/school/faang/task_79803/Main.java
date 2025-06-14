package school.faang.task_79803;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Щит", "Атака отражена");
        hogwartsSpells.addSpellEvent("ФаерБолл", "Атака");
        hogwartsSpells.addSpellEvent("Каменная плита", "Атака");
        hogwartsSpells.addSpellEvent("Каменная плита", "Атака");
        hogwartsSpells.addSpellEvent("Каменная плита", "Атака");

        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println(hogwartsSpells.getSpellEventsByType("Каменная плита"));
        hogwartsSpells.deleteSpellEvent(4);
        System.out.println(hogwartsSpells.getSpellEventsByType("Каменная плита"));
        hogwartsSpells.printAllSpellEvents();
    }
}
