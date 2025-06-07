package school.faang.bjs2_79052;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Отражение", "Отражает заклинание");
        hogwartsSpells.addSpellEvent("Трансмутация", "Преобразует предметы в лед");
        hogwartsSpells.addSpellEvent("Трансмутация", "Преобразует предметы в огонь");
        hogwartsSpells.addSpellEvent("Чар", "Накладывает отравление на предмет");
        hogwartsSpells.addSpellEvent("Чар", "Закаляет предмет до 100C");
        hogwartsSpells.addSpellEvent("Атака", "Создает сгусток белого света");

        System.out.println(hogwartsSpells.getSpellEventByld(1));
        System.out.println(hogwartsSpells.getSpellEventsByType("Трансмутация"));
        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
    }
}
