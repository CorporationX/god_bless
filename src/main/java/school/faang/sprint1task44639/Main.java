package school.faang.sprint1task44639;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells testSpell = new HogwartsSpells();

        testSpell.addSpellEvent(1, "Защита", "Защищает от атак 1");
        testSpell.addSpellEvent(2, "Трансфигурация", "Преобразует предмет");
        testSpell.addSpellEvent(3, "Чар", "Защищает от атак 2");

        testSpell.printAllSpellEvents();
    }
}