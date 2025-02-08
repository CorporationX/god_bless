package school.faang.BJS2_57150;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Чар", "Увеличивает скорость передвижения");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Отражает магические атаки");
        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println(hogwartsSpells.getSpellEventsByType("Защита"));
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
    }
}
