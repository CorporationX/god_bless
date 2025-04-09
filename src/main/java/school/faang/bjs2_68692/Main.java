package school.faang.bjs2_68692;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чары", "Магия огня");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Превращение в кошку");
        hogwartsSpells.addSpellEvent("Защита", "Защита от физических атак");
        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(3));
        System.out.println(hogwartsSpells.getSpellEventsByType("Трансфигурация"));

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(99));
        hogwartsSpells.deleteSpellEvent(5555);
        hogwartsSpells.printAllSpellEvents();
    }
}
