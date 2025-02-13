package school.faang;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от огня");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");

        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventByType("Защита"));
        System.out.println(hogwartsSpells.getSpellEventByType(""));

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();

    }
}
