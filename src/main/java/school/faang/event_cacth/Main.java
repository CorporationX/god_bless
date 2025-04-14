package school.faang.event_cacth;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");

        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventsByType("Защита"));
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.getSpellEventById(1);
    }
}
