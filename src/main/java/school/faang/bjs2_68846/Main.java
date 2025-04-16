package school.faang.bjs2_68846;

/**
 * Задача "Ловим события"
 */
public class Main {
    public static void main(String[] args) {
        var hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Чар", "Файербол");
        hogwartsSpells.addSpellEvent("Чар", "Стена огня");
        hogwartsSpells.addSpellEvent("Чар", "Файербол");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от яда");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от огня");

        hogwartsSpells.printAllSpellEvents();

        System.out.println("\nПоиск заклинания по ID:");
        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventById(272021213));
        System.out.println(hogwartsSpells.getSpellEventById(-1213214793));
        System.out.println(hogwartsSpells.getSpellEventById(("Чар" + "Стена огня").hashCode()));

        System.out.println("\nСписок всех заклинаний:");
        System.out.println(hogwartsSpells.getSpellEventsByType("Защита"));
        System.out.println(hogwartsSpells.getSpellEventsByType("Некромантия"));

        System.out.println("\nУдалим \"стену огня\" и \"защиту от атак\"");
        hogwartsSpells.deleteSpellEvent(("Чар" + "Стена огня").hashCode());
        hogwartsSpells.deleteSpellEvent(-158185974);

        hogwartsSpells.printAllSpellEvents();
    }
}
