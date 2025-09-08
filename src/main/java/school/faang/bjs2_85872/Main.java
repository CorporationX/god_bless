package school.faang.bjs2_85872;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Fire", "light a match");
        spells.addSpellEvent("Water", "create water flow");
        spells.addSpellEvent("Fire", "create fireball");
        spells.addSpellEvent("Wind", "generate breeze");

        System.out.println("\nПоиск закдинаний по ID");
        System.out.println(spells.getSpellEventById(1));

        System.out.println("\nПоиск заклинаний по типу Заклинания");
        System.out.println(spells.getSpellEventsByType("Fire"));

        System.out.println("\nВсе заклинания:");
        spells.printAllSpellEvents();

        System.out.println("\nУдаление заклинания с ID");
        spells.deleteSpellEvent(2);

        System.out.println("\nОставшиеся заклинания после удаления:");
        spells.printAllSpellEvents();

        System.out.println("\nПоиск закдинаний по ID");
        System.out.println(spells.getSpellEventById(2));

        System.out.println("\nПоиск заклинаний по типу Заклинания");
        System.out.println(spells.getSpellEventsByType("Water"));
    }
}
